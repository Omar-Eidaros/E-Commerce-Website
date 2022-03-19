/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.store;

import database.DataHandling;
import database.MongoDBHandler;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nora
 */
public class HandleInitServer extends HttpServlet {

    @Override
    public void init() {
        try {
            DataHandling.startConnection();
            MongoDBHandler.connectDB();
        } catch (Exception e) {
            System.out.println(e+" : error to start connection");
        }
    }
}
