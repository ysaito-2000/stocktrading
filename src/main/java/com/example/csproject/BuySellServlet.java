package com.example.csproject;

import com.example.csproject.stock.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "BuySellServlet", value = "/buysellservlet")
public class BuySellServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double amountBought = Double.parseDouble((String) request.getParameter("buy"));
        double amountSold = Double.parseDouble((String) request.getParameter("sell"));

        User currentUser = (User) getServletContext().getAttribute("currentUser");
        String currentStock = (String) getServletContext().getAttribute("currentStock");

        if (amountBought != 0.0) {

        }

        if (amountSold != 0.0) {

        }

        getServletContext().getRequestDispatcher("/portal.jsp").forward(request,response);
    }
}
