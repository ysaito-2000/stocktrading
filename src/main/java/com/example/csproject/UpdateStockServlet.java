package com.example.csproject;

import com.example.csproject.stock.DataPoint;
import com.example.csproject.stock.Database;
import com.example.csproject.stock.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "UpdateStockServlet", value = "/updatestockservlet")
public class UpdateStockServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double price = Double.parseDouble((String) request.getParameter("new-stock-price"));
        String date = (String) request.getParameter("new-stock-date");

        String currentStock = (String) getServletContext().getAttribute("currentStock");
        Database database = (Database) getServletContext().getAttribute("database");

        database.updateStock(currentStock, date, 0.0, price, 0);
        ArrayList<DataPoint> stockData = database.getData(currentStock);

        getServletContext().getRequestDispatcher("/portal").forward(request,response);
    }
}
