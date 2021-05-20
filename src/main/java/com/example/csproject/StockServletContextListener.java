package com.example.csproject;

import com.example.csproject.stock.Database;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;

public class StockServletContextListener implements ServletContextListener {

    /*
     *  @param sce ServletContextEvent object made upon Server creation
     *  Destroys context (i.e. public variables accessible by servlets) on shutdown
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContextListener destroyed");
    }

    /*
    *   @param sce ServletContextEvent object made upon Server creation
    *   Generates context (i.e. public variables accessible by servlets) on startup
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
        sce.getServletContext().setAttribute("currentStock", "Apple");

        System.out.println("ServletContextListener started");
    }
}
