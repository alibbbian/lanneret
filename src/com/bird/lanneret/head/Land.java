package com.bird.lanneret.head;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by renwp on 2017/4/15.
 */
public final class Land {

    private int LISTENER_PORT = 4043;

    public Land(int listener_port) {
        LISTENER_PORT = listener_port;
    }

    /**
     * 发送关闭命令
     */
    void execute() {
        Socket socket = new Socket();
        OutputStream outputStream = null;
        try {
            socket.connect(new InetSocketAddress("localhost", LISTENER_PORT));
            outputStream = socket.getOutputStream();
            outputStream.write("shutdown".getBytes());
            System.out.println("关闭命令已发送，端口号".concat(LISTENER_PORT+""));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
