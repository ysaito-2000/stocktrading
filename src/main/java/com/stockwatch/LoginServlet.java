package com.stockwatch;

import com.stockwatch.stock.Database;
import com.stockwatch.stock.User;

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
     *  @param request  Object embodiment of POST request
     *  @param response Object embodiment of server response to request
     *  @return directs User to login page
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
    }

    /*
     *  @param request  Object embodiment of POST request
     *  @param response Object embodiment of server response to request
     *
     *  Determines if User is contained within database
     *  Sets valid Users as global objects
     *
     *  @return portal page
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