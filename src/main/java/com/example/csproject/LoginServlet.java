package com.example.csproject;

import com.example.csproject.stock.Database;
import com.example.csproject.stock.User;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.servlet.ServletException;

@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    /*
    *  Processes GET requests to login page, returns login page
    */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("A login get request was made");

        getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
    }

    /*
     *  Processes POST requests to login page, determines if user
     *  returns to login page or proceeds to portal
     *
     *  Passes control to PortalServlet to process user information
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("A login post request was made");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Database database = (Database) getServletContext().getAttribute("database");
        User currentUser = database.getUser(username, password);


        if (!database.verifyUser(currentUser)) {
            request.setAttribute("error", "Invalid Username and/or Password");
            doGet(request, response);
        } else {
            getServletContext().setAttribute("currentUser", currentUser);
            getServletContext().getRequestDispatcher("/portal").forward(request,response);
        }
    }
}