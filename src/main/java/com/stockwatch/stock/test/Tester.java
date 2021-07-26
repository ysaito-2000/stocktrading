package com.stockwatch.stock.test;
import com.stockwatch.stock.DataPoint;
import com.stockwatch.stock.Database;

import java.io.IOException;
import java.util.*;

/**
 * Tester class used for testing various components and classes.
 */
public class Tester {

    public static void main(String[] args) throws IOException {
        Database base = new Database();
        base.readData("Apple");
        ArrayList<DataPoint> data = base.getData("Apple");
        base.updateStock("Apple", "yes", 10, 10, 10);

        for (DataPoint x: data)
        {
            System.out.println(x.getDate());
        }
    }
}
