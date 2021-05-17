package com.example.csproject.stock;
import java.util.*;
import java.io.*;

/**
 * Database Object used for aggregating Stock and User objects.
 */
public class Database{
    private static Set<User> userSet = new HashSet<>();
    private static Set<Stock> stockSet = new HashSet<>();
    private static Map<String, ArrayList<DataPoint>> stockData = new HashMap<>();

    /**
     * Constructor for Database. Hard codes a default user and adds it to the userSet.
     */
    public Database() {
        User user1 = new User("admin", "12345");
        this.addUser(user1);
    }

    /**
     * Reads the data of the passed in stock's .txt Used to generate an ArrayList of DataPoints to be passed into the
     * Database's stockData HashMap.
     * @param s The name of the stock's .txt file (Same as the name of the stock itself). Options include Apple, Goog,
     *          and Spy.
     * @throws IOException
     */
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

    /**
     * Getter for the stock's ArrayList of DataPoints
     * @param stock The name of the stock to get the DataPoint's of.
     * @return  An ArrayList the passed in stock's DataPoints
     */
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

    /**
     * Adds a stock the Database's stockSet.
     * @param s The stock to be added.
     */
    public void addStock(Stock s)
    {
        stockSet.add(s);
    }

    /**
     * Updates a stock's values by adding a new DataPoint.
     * @param stock The name of the stock to be updated.
     * @param date  The new Date.
     * @param open  The new opening value.
     * @param close The new closing value.
     * @param volume    The new volume.
     * @throws IOException
     */
    public void updateStock(String stock, String date, double open, double close, int volume) throws IOException
    {
        ArrayList<DataPoint> data = stockData.get(stock);
        DataPoint newData = new DataPoint(date, open,close,volume);
        data.add(0, newData);
    }

    /**
     * Adds a new user to the Database's userSet.
     * @param u The new user to be added.
     */
    public void addUser(User u)
    {
        userSet.add(u);
    }

    /**
     * Gets a user from the userSet by passing in that user's username and password.
     * @param user  The user's username.
     * @param pass  The user's password
     * @return  Returns the User object if the username and password correspond with a user. Returns null otherwise.
     */
    public User getUser(String user, String pass) {
        User theUser = null;

        for (User i : userSet) {
            if (i.getUsername().equals(user) && i.getPassword().equals(pass)) {
                theUser = i;
            }
        }

        return theUser;
    }

    /**
     * Verifies the passed in user by seeing if the userSet HashSet contains that user.
     * @param i The user object to be verified.
     * @return  Returns true if the user is in the userSet. Returns false otherwise.
     */
    public boolean verifyUser(User i) {
        return userSet.contains(i);
    }

}

