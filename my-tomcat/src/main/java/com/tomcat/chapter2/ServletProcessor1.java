package com.tomcat.chapter2;

import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

public class ServletProcessor1 {

    private static final String SERVLET_CLASSPATH = System.getProperty("user.dir") + File.separator + "my-tomcat" +
            File.separator+ "webroot";

    public void process(Request request, Response response) {
        String uri = request.getUri();
        String servletName = uri.substring(uri.lastIndexOf("/") + 1);
        URLClassLoader loader = null;
        try {
            //create a URLClassLoader
            URL[] urls = new URL[1];
            URLStreamHandler streamHandler = null;
            File classPath = new File(SERVLET_CLASSPATH);
            // the forming of responsitory is takent from the
            // createClassLoader method in
            // org.apache.catalian.startup.ClassLoaderFactory
            String repository = (new URL("file", null, classPath.getCanonicalPath() + File.separator)).toString();
            // the code form forming the URL is taken from the addRespository method in
            // org.apache.catalina.loader.StandardClassLoader
            urls[0] = new URL(null, repository, streamHandler);
            loader = new URLClassLoader(urls);
        } catch(Exception e) {
            e.printStackTrace();
        }

        Class myClass = null;
        try {
            myClass = loader.loadClass(servletName);
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        Servlet servlet = null;

        try {
            servlet = (Servlet) myClass.newInstance();
            servlet.service((ServletRequest)request, (ServletResponse)response);
        } catch(Exception e) {
            e.printStackTrace();
        }


    }
}
