/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/ServletListener.java to edit this template
 */
package com.store;

import database.DataHandling;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionListener;

/**
 * Web application lifecycle listener.
 *
 * @author nora
 */
public class handleListenerContext implements ServletContextListener {
   
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("the app is deployed");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        System.out.println("the app is undeployed");

        try {
            DataHandling.closeConnection();
       
 
        } catch (Exception e) {
            System.out.println(e + " : error to start connection");
        }

    }
}
