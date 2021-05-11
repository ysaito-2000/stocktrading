package com.example.csproject;

import com.example.csproject.stock.Database;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;

public class StockServletContextListener implements ServletContextListener {

    /*
     *   Destroys context (i.e. public variables accessible by servlets)
     *   Is ran on tomcat shutdown.
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContextListener destroyed");
    }

    /*
    *   Generates context (i.e. public variables accessible by servlets)
    *   Is ran on tomcat startup.
    */
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        Database data = new Database();

        try {
            data.readData("Apple");
            data.readData("Goog");
            data.readData("Spy");
        } catch (IOException e) {
            e.printStackTrace();
        }


        sce.getServletContext().setAttribute("database", data);

        System.out.println("ServletContextListener started");
    }
}
