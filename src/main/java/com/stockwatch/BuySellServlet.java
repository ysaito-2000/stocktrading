package com.stockwatch;

import com.stockwatch.stock.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "BuySellServlet", value = "/buysellservlet")
public class BuySellServlet extends HttpServlet {

    /*
     *   @param request  Object embodiment of POST request
     *   @param response Object embodiment of server response to request
     *
     *   Updates User data on amount of current stock owned
     *
     *   @return directs User to portal page
     */
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
