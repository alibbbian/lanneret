package com.bird.lanneret.head;

import java.util.regex.Pattern;

/**
 * Created by renwp on 2017/4/15.
 */
public final class Command {

    private Command() {
    }

    public static void main(String[] args){
        int argsLength = args.length;
        try {
            if (args != null && args.length > 0) {
                if(argsLength > 1){
                    if(!Pattern.matches("^[0-9]{1,5}$", args[1])){
                        args[1] = "4043";
                    }
                }
                int listener_port = argsLength > 1 ? Integer.parseInt(args[1]) : 4043;

                String command = args[0];
                switch (command) {
                    case "start":
                        Fly fly = new Fly(listener_port);
                        fly.start();
                        break;
                    case "shutdown":
                        Land land = new Land(listener_port);
                        land.execute();
                        break;
                    default:
                        System.err.println("无效命令...");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("启动失败...");
        } finally {
            System.exit(0);
        }
    }

}
