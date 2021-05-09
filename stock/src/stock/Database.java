package stock;

import java.util.*;
import java.io.*;

public class Database {

    public ArrayList<DataPoint> getData() throws IOException
    {
        ArrayList<DataPoint> values = new ArrayList<DataPoint>();
        File input = new File("data/Apple.txt");
        FileReader fr = new FileReader(input);
        BufferedReader br = new BufferedReader(fr);
        try
        {
            String read = br.readLine();
            while(read != null)
            {
                read = br.readLine();
                if(read !=null)
                {
                	String[] data = read.split(", ");
                	DataPoint newData = new DataPoint(data[0], Double.parseDouble(data[1]), Double.parseDouble(data[2]), Integer.parseInt(data[3]));
                	values.add(newData);
                }
            }
        }
        catch (FileNotFoundException e)
        {
            e = new FileNotFoundException("File not found");
            System.out.println(e);
        }
        return values;
    }

    /*
    public HashSet<Stock> accessData(User u)
    {

    }

     */
    public void addStock(Stock s)
    {

    }

    public void updateStock()
    {

    }

    public void addUser(User u)
    {

    }

    public void updateUser(User u)
    {

    }
}
