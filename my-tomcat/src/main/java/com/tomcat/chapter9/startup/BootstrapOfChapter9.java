package com.tomcat.chapter9.startup;


import com.tomcat.chapter9.core.SimpleContextConfig;
import com.tomcat.chapter9.core.SimpleWrapper;
import org.apache.catalina.*;
import org.apache.catalina.connector.http.HttpConnector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.loader.WebappLoader;
import org.apache.catalina.session.StandardManager;

public final class BootstrapOfChapter9 {

    public static void main(String[] args) {
        //invoke: http://localhost:8080/myApp/Session
        System.setProperty("catalina.base", System.getProperty("user.dir"));
        Connector connector = new HttpConnector();
        Wrapper wrapper1 = new SimpleWrapper();
        wrapper1.setName("Session");
        wrapper1.setServletClass("SessionServlet");

        Context context = new StandardContext();
        // StandardContext's start method adds a default mapper
        context.setPath("\\my-tomcat\\myServletsClass");
        context.setDocBase("my-tomcat\\myServletsClass");

        context.addChild(wrapper1);

        // context.addServletMapping(pattern, name);
        // note that we must use /myApp/Session, not just /Session
        // because the /myApp section must be the same as the path, so the cookie will
        // be sent back.
        context.addServletMapping("/servlet/Session", "Session");
        // add ContextConfig. This listener is important because it configures
        // StandardContext (sets configured to true), otherwise StandardContext
        // won't start
        LifecycleListener listener = new SimpleContextConfig();
        ((Lifecycle) context).addLifecycleListener(listener);

        // here is our loader
        Loader loader = new WebappLoader();
        // associate the loader with the Context
        context.setLoader(loader);

        connector.setContainer(context);

        // add a Manager
        Manager manager = new StandardManager();
        context.setManager(manager);

        try {
            connector.initialize();
            ((Lifecycle) connector).start();

            ((Lifecycle) context).start();

            // make the application wait until we press a key.
            System.in.read();
            ((Lifecycle) context).stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}