package com.example.csproject.stock;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.io.*;

import org.junit.jupiter.api.Test;

class TestCases {

    Database base = new Database();

    //tests database methods
    @Test
    void basicTest() throws IOException{

        base.readData("Apple");
        ArrayList<DataPoint> data = base.getData("Apple");
        base.updateStock("Apple", "yes", 10, 10, 10);

        for (DataPoint x: data)
        {
            System.out.println(x.toString());
        }


        DataPoint point = new DataPoint("yes", 10, 10, 10);
        assertEquals(data.get(0).toString(), point.toString());
    }

    //tests user methods
    @Test
    void userTest()
    {
        User use = new User("Joe", "Jaco");
        use.changeUsername("Joel");
        use.changePassword("Jacob");
    }

    //tests that readData works
    @Test
    void readTest() throws IOException
    {
        base.readData("Apple");
        ArrayList<DataPoint> data = base.getData("Apple");
        try
        {
            FileWriter fw= new FileWriter("data/result.txt");
            fw.write("Date, Open, Close, Volume" + "\n");
            for(DataPoint d: data)
            {
                fw.write(d.toString() + "\n");
            }
            fw.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        base.readData("result");
        ArrayList<DataPoint> result = base.getData("result");
        int i = 0;
        for (DataPoint d: result)
        {
            assertEquals(d.toString(), data.get(i).toString());
            i++;
        }
    }
}