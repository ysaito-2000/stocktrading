package stock;

import java.util.*;
import java.io.*;

public class Database {
    private static Set<User> userSet = new HashSet<>();
    private static Set<Stock> stockSet = new HashSet<>();

    public ArrayList<DataPoint> getData() throws IOException
    {
        ArrayList<DataPoint> values = new ArrayList<>();
        File input = new File("stock/data/Apple.txt");
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
        stockSet.add(s);
    }

    public void updateStock()
    {

    }

    public void addUser(User u)
    {
        userSet.add(u);
    }

    public void updateUser(User u)
    {

    }

    public boolean verifyUser(User u) {
        return userSet.contains(u);
    }
}
