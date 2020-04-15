package com.tomcat.chapter14.startup;

import com.tomcat.chapter14.core.SimpleContextConfig;
import org.apache.catalina.*;
import org.apache.catalina.connector.http.HttpConnector;
import org.apache.catalina.core.*;
import org.apache.catalina.loader.WebappLoader;

public final class BootstrapOfChapter14 {
    public static void main(String[] args) {

        System.setProperty("catalina.base", System.getProperty("user.dir"));
        Connector connector = new HttpConnector();

        Wrapper wrapper1 = new StandardWrapper();
        wrapper1.setName("Primitive");
        wrapper1.setServletClass("PrimitiveServlet");
        Wrapper wrapper2 = new StandardWrapper();
        wrapper2.setName("Modern");
        wrapper2.setServletClass("ModernServlet");

        Context context = new StandardContext();
        // StandardContext's start method adds a default mapper
        context.setPath("/contextA");
        context.setDocBase("contextA");

        context.addChild(wrapper1);
        context.addChild(wrapper2);

        LifecycleListener listener = new SimpleContextConfig();
        ((Lifecycle) context).addLifecycleListener(listener);

        Host host = new StandardHost();
        host.addChild(context);
        host.setName("hostA");
        host.setAppBase("/my-tomcat/webapps");

        Loader loader = new WebappLoader();
        context.setLoader(loader);
        // context.addServletMapping(pattern, name);
        context.addServletMapping("/Primitive", "Primitive");
        context.addServletMapping("/Modern", "Modern");

        Engine engine = new StandardEngine();
        engine.addChild(host);
        engine.setDefaultHost("localhost");

        Service service = new StandardService();
        service.setName("Stand-alone Service");
        Server server = new StandardServer();
        server.addService(service);
        service.addConnector(connector);

        //StandardService class's setContainer will call all its connector's setContainer method
        service.setContainer(engine);

        // Start the new server
        if (server instanceof Lifecycle) {
            try {
                server.initialize();
                ((Lifecycle) server).start();
                server.await();
                // the program waits until the await method returns,
                // i.e. until a shutdown command is received.
            } catch (LifecycleException e) {
                e.printStackTrace(System.out);
            }
        }

        // Shut down the server
        if (server instanceof Lifecycle) {
            try {
                ((Lifecycle) server).stop();
            } catch (LifecycleException e) {
                e.printStackTrace(System.out);
            }
        }
    }
}