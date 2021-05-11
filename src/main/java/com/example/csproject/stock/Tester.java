package com.example.csproject.stock;
import java.io.IOException;
import java.util.*;

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
