package com.bird.lanneret.head;

import com.bird.lanneret.core.ScanPackage;
import com.bird.lanneret.core.Server;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by renwp on 2017/4/15.
 */
public final class Fly {

    private int LISTENER_PORT = 4043;
    private ExecutorService executorService = Executors.newFixedThreadPool(10);

    private Map<String, Server> ServerMap = new HashMap<>(7);


    public Fly(int listener_port) {
        LISTENER_PORT = listener_port;
    }

    /**
     * 启动
     */
    public void start() {
        try{
            executorService.execute(()->{
                ScanPackage.scan(aClass -> {
                    if(Server.class.isAssignableFrom(aClass) && aClass != Server.class){
                        try {
                            Server server = (Server) aClass.newInstance();
                            ServerMap.put(aClass.getName(), server);
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                });
                ServerMap.forEach((serverName, server) -> server.fly());
            });
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("起飞成功......");
        // 监听
        listener();
    }

    /**
     * 关闭
     */
    private void shutdown(){
        try{
            ServerMap.forEach((serverName, server) -> server.land());
        }catch (Exception e){
            e.printStackTrace();
        }
        executorService.shutdown();
        System.out.println("成功关闭");
    }

    /**
     * 启动监听接口，监听命令
     */
    public void listener(){
        Socket accept = null;
        InputStream inputStream = null;
        try (ServerSocket serverSocket = new ServerSocket(LISTENER_PORT, 1, InetAddress.getByName("localhost"))) {
            System.out.println("监听已启动：端口号".concat(LISTENER_PORT+""));
            while(true){
                accept = serverSocket.accept();
                InetAddress inetAddress = accept.getInetAddress();
                System.out.println(inetAddress.getHostAddress());

                inputStream = accept.getInputStream();
                byte[] bb = new byte[1024];
                int read = inputStream.read(bb);

                String result = new String(bb, 0, read);
                System.out.println(result);

                inputStream.close();
                inputStream = null;

                accept.close();
                accept = null;

                // 本地通讯才做关闭操作
                if((inetAddress.getHostAddress().equals("localhost") || inetAddress.getHostAddress().equals("127.0.0.1"))
                        && result.equals("shutdown")){
                    shutdown();
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(accept != null){
                    accept.close();
                }
                if(inputStream != null){
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
