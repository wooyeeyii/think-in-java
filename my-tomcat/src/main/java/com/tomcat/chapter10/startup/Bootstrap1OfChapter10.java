package com.tomcat.chapter10.startup;

import com.tomcat.chapter10.core.SimpleContextConfig;
import com.tomcat.chapter10.core.SimpleWrapper;
import com.tomcat.chapter10.realm.SimpleRealm;
import org.apache.catalina.*;
import org.apache.catalina.connector.http.HttpConnector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.deploy.LoginConfig;
import org.apache.catalina.deploy.SecurityCollection;
import org.apache.catalina.deploy.SecurityConstraint;
import org.apache.catalina.loader.WebappLoader;

public final class Bootstrap1OfChapter10 {

    public static void main(String[] args) {
        //invoke: http://localhost:8080/Modern or  http://localhost:8080/Primitive
        System.setProperty("catalina.base", System.getProperty("user.dir"));
        Connector connector = new HttpConnector();
        Wrapper wrapper1 = new SimpleWrapper();
        wrapper1.setName("Primitive");
        wrapper1.setServletClass("PrimitiveServlet");
        Wrapper wrapper2 = new SimpleWrapper();
        wrapper2.setName("Modern");
        wrapper2.setServletClass("ModernServlet");

        Context context = new StandardContext();
        // StandardContext's start method adds a default mapper
        context.setPath("\\my-tomcat\\myServletsClass");
        context.setDocBase("my-tomcat\\myServletsClass");

        context.addChild(wrapper1);
        context.addChild(wrapper2);

        // context.addServletMapping(pattern, name);
        context.addServletMapping("/Primitive", "Primitive");
        context.addServletMapping("/Modern", "Modern");

        // add ContextConfig. This listener is important because it configures
        // StandardContext (sets configured to true), otherwise StandardContext
        // won't start
        LifecycleListener listener = new SimpleContextConfig();
        ((Lifecycle) context).addLifecycleListener(listener);

        Loader loader = new WebappLoader();
        context.setLoader(loader);

        // for simplicity, we don't add a valve, but you can add
        // valves to context or wrapper just as you did in Chapter 6

        // add realm    necessary
        Realm realm = new SimpleRealm();
        context.setRealm(realm);

        // add constraint
        SecurityCollection securityCollection = new SecurityCollection();
        securityCollection.addPattern("/");
        securityCollection.addMethod("GET");
        SecurityConstraint constraint = new SecurityConstraint();
        constraint.addCollection(securityCollection);
        constraint.addAuthRole("manager");
        context.addConstraint(constraint);

        //  necessary
        LoginConfig loginConfig = new LoginConfig();
        loginConfig.setRealmName("Simple Realm");
        context.setLoginConfig(loginConfig);


        connector.setContainer(context);
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