package com.stockwatch;

import com.stockwatch.stock.DataPoint;
import com.stockwatch.stock.Database;
import com.stockwatch.stock.User;
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
    /*
     *   @param request  Object embodiment of POST request
     *   @param response Object embodiment of server response to request
     *
     *   Sets currently selected stock as a global variable via JSON format
     *   Checks if User has buy/sell limits on the selected stock
     *
     *   @return directs User to portal page
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Database database = (Database) getServletContext().getAttribute("database");
        User currentUser = (User) getServletContext().getAttribute("currentUser");
        String currentStock = (String) getServletContext().getAttribute("currentStock");

        ArrayList<DataPoint> stockData = database.getData(currentStock);
        Collections.reverse(stockData);
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(stockData);
        getServletContext().setAttribute("stockJSON", jsonString);

        Collections.reverse(stockData);

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
