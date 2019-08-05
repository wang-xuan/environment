package com.itwx.environment.jvm.chapter7;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author:wx
 * @Date:2019/6/20 10:36
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader myLoader = new ClassLoader(){
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".")+1)+".class";

                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null){
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name,b,0,b.length);
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new ClassNotFoundException(name);
                }
            }
        };
        //加载并实例化该类的对象
        Object obj = myLoader.loadClass("com.itwx.environment.jvm.chapter7.ClassLoaderTest").newInstance();
        //虚拟机中存在两个ClassLoaderTest类，一个是系统应用程序加载的，另一个是我们自定义的类加载器加载的，虽然在同一个文件中，但依然是两个独立的类
        System.out.println(obj instanceof com.itwx.environment.jvm.chapter7.ClassLoaderTest);
    }
}
