package com.example.csproject;

import com.example.csproject.stock.Database;
import com.example.csproject.stock.Stock;
import com.example.csproject.stock.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ReminderServlet", value = "/reminderservlet")
public class ReminderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double amount = Double.parseDouble(request.getParameter("stock-amount"));
        int price = Integer.parseInt(request.getParameter("stock-price"));

        User currentUser = (User) getServletContext().getAttribute("currentUser");
        String currentStock = (String) getServletContext().getAttribute("currentStock");
        Database database = (Database) getServletContext().getAttribute("database");
        Stock i = database.getStock(currentStock);

        if (request.getParameter("remind").equals("remind-buy")) {
            currentUser.setBuyPrice(i, price);
            currentUser.watchStock(i);
        } else {
            currentUser.setSellPrice(i, price);
            currentUser.watchStock(i);
        }

        getServletContext().getRequestDispatcher("/portal.jsp").forward(request,response);
    }
}
