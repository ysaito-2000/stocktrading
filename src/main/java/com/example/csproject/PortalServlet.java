package com.example.csproject;

import com.example.csproject.stock.Database;
import com.example.csproject.stock.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PortalServlet", value = "/portal")
public class PortalServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("A portal get request was made");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("A portal post request was made");

        // Insert code to get information from database
        Database database = (Database) getServletContext().getAttribute("database");
        User currentUser = (User) getServletContext().getAttribute("currentUser");

//        String userJSON = database.getUserDataJSON(currentUser);

        getServletContext().getRequestDispatcher("/portal.jsp").forward(request,response);

    }
}
