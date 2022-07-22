package com.my.test;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestHttpServelet extends HttpServlet {
   @Override
   public void doGet(HttpServletRequest req, HttpServletResponse response)
   {

       System.out.println("im in do get");

    }
}
