package com.example.csproject;

import com.example.csproject.stock.Database;
import com.example.csproject.stock.User;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.servlet.ServletException;

/*
*   Servlet mapped to url + /login
*/
@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    /*
    *  Processes GET requests to login page, returns login page
    */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("A login get request was made");

        /*
        *   Users redirected to index.jsp (i.e. home/login page)
        */
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

        /*
        *   Login information taken from client
        */
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        /*
        *   Grab global variable Database from ServletContext
        *   Get user from database
        */
        Database database = (Database) getServletContext().getAttribute("database");
        User currentUser = database.getUser(username, password);

        if (!database.verifyUser(currentUser)) {
            /*
            *   Send user back to login page
            */
            request.setAttribute("error", "Invalid Username and/or Password");
            doGet(request, response);
        } else {
            /*
            *   Store User in global context
            *   Move control to PortalServlet
            */
            getServletContext().setAttribute("currentUser", currentUser);
            getServletContext().getRequestDispatcher("/portal").forward(request,response);
        }
    }
}