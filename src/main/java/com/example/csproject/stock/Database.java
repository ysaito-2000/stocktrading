package com.example.csproject.stock;
import java.util.*;
import java.io.*;

public class Database{
    private static Set<User> userSet = new HashSet<>();
    private static Set<Stock> stockSet = new HashSet<>();
    private static Map<String, ArrayList<DataPoint>> stockData = new HashMap<>();

    public Database() {
        User user1 = new User("admin", "12345");
        this.addUser(user1);
    }

    public void readData(String s) throws IOException
    {
        ArrayList<DataPoint> values = new ArrayList<>();
        File input = new File("C:/Users/Yuki/Documents/School/CS 151/csproject/src/main/java/com/example/csproject/data/"+s+".txt");

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
        fr.close();
        br.close();
        stockData.put(s,values);

        DataPoint lastDP = values.get(values.size() - 1);

        Stock last = new Stock(s, s, lastDP.getClose(), lastDP.getVolume());
        this.addStock(last);
    }

    public ArrayList<DataPoint> getData(String stock)
    {
        return stockData.get(stock);
    }

    public Stock getStock(String stock) {
        for (Stock i : stockSet) {
            if (i.getName().equals(stock)) {
                return i;
            }
        }
        return null;
    }

    public void addStock(Stock s)
    {
        stockSet.add(s);
    }

    public void updateStock(String stock, String date, double open, double close, int volume) throws IOException
    {
        ArrayList<DataPoint> data = stockData.get(stock);
        DataPoint newData = new DataPoint(date, open,close,volume);
        data.add(0, newData);
    }

    public void addUser(User u)
    {
        userSet.add(u);
    }

    public User getUser(String user, String pass) {
        User theUser = null;

        for (User i : userSet) {
            if (i.getUsername().equals(user) && i.getPassword().equals(pass)) {
                theUser = i;
            }
        }

        return theUser;
    }

    public boolean verifyUser(User i) {
        return userSet.contains(i);
    }

}

