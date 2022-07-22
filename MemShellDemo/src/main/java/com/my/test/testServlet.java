package com.my.test;

import javax.servlet.*;
import java.io.IOException;

public class testServlet implements Servlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("in my testServlet init");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("in my testServlet service" );
        res.getWriter().write("in my testServlet service");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
