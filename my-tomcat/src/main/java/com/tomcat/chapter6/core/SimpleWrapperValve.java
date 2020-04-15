package com.tomcat.chapter6.core;

import org.apache.catalina.*;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class SimpleWrapperValve implements Valve, Contained {

    protected Container container;

    public void invoke(Request request, Response response, ValveContext valveContext)
            throws IOException, ServletException {

        SimpleWrapper wrapper = (SimpleWrapper) getContainer();
        ServletRequest sreq = request.getRequest();
        ServletResponse sres = response.getResponse();
        Servlet servlet = null;
        HttpServletRequest hreq = null;
        if (sreq instanceof HttpServletRequest)
            hreq = (HttpServletRequest) sreq;
        HttpServletResponse hres = null;
        if (sres instanceof HttpServletResponse)
            hres = (HttpServletResponse) sres;

        // Allocate a servlet instance to process this request
        try {
            servlet = wrapper.allocate();
            if (hres != null && hreq != null) {
                servlet.service(hreq, hres);
            } else {
                servlet.service(sreq, sres);
            }
        } catch (ServletException e) {
        }
    }

    public String getInfo() {
        return null;
    }

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }
}