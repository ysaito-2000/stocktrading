package com.example.csproject;

import com.example.csproject.stock.DataPoint;
import com.example.csproject.stock.Database;
import com.example.csproject.stock.User;
import com.example.csproject.stock.UserHelper;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/*
 *   Servlet mapped to url + /portal
 */
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
        String currentStock = (String) getServletContext().getAttribute("currentStock");

        ArrayList<DataPoint> stockData = database.getData(currentStock);
        Collections.reverse(stockData);
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(stockData);
        getServletContext().setAttribute("stockJSON", jsonString);

        Double buyPrice = currentUser.getRemindBuyPrice(database.getStock(currentStock));
        Double sellPrice = currentUser.getRemindSellPrice(database.getStock(currentStock));

        ArrayList<DataPoint> stockDataTwo = database.getData(currentStock);

        if (buyPrice != null) {
            if (buyPrice > stockDataTwo.get(1).getClose()) {
                if (stockDataTwo.get(0).getClose() <= buyPrice) {
                    getServletContext().setAttribute("shouldBuy", "true");
                }
            } else if (buyPrice < stockDataTwo.get(1).getClose()) {
                if (stockDataTwo.get(0).getClose() >= buyPrice) {
                    getServletContext().setAttribute("shouldBuy", "true");
                }
            }
        }

        if (sellPrice != null) {
            if (sellPrice > stockDataTwo.get(1).getClose()) {
                if (stockDataTwo.get(0).getClose() <= sellPrice) {
                    getServletContext().setAttribute("shouldSell", "true");
                }
            } else if (sellPrice < stockDataTwo.get(1).getClose()) {
                if (stockDataTwo.get(0).getClose() >= sellPrice) {
                    getServletContext().setAttribute("shouldSell", "true");
                }
            }
        }

        getServletContext().getRequestDispatcher("/portal.jsp").forward(request,response);
    }
}
