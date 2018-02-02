package com.bird.lanneret.core;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * Created by renwp on 2017/5/11.
 */
public final class ScanPackage {

    public static void scan(Call call){
        try {
            Enumeration<URL> resources = Thread.currentThread().getContextClassLoader().getResources("");
            File file;
            while (resources.hasMoreElements()){
                URL url = resources.nextElement();
                if("file".equals(url.getProtocol())){
                    file = new File(url.getPath());
                    if(file.isDirectory()){
                        dirFile(file, file.getPath(), call);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void dirFile(File file, String path, Call call) throws ClassNotFoundException {
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for(int i = 0, len = files.length; i < len; i++){
                dirFile(files[i], path, call);
            }
        }else{
            if(file.getPath().endsWith(".class")){
                String className = file.getPath().substring(path.length()+1).replace(File.separator, ".").replace(".class", "");
                call.doSomething(Class.forName(className));
            }
        }
    }

    public interface Call{
        void doSomething(Class<?> className);
    }

}
