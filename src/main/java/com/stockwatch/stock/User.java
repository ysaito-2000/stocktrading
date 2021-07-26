package com.stockwatch.stock;
import java.util.*;

/**
 * Object representing a user. Contains username, password, balance, and various Sets and Maps representing the user's
 * owned stocks, watchlist, amount of stocks owned, and reminders for buying and selling those stocks.
 */
public class User {

    private String username;
    private String password;

    private float balance;

    private static Set<Stock> watchlist = new HashSet<>();
    private static Set<Stock> ownedSet = new HashSet<>();
    private static Map<Stock, Double> amountOwned = new HashMap<>();
    private static Map<Stock, Double> remindBuy = new HashMap<>();
    private static Map<Stock, Double> remindSell = new HashMap<>();

    /**
     * Constructor User object. Takes in a username and password. Has a default balance of 1000.
     * @param username
     * @param password
     */
    public User(String username, String password)
    {
        this.username = username;
        this.password = password;
        this.balance = 1000;
    }

    /**
     * Setter for a User's username
     * @param u The new username.
     */
    public void changeUsername(String u)
    {
        this.username = u;
    }

    /**
     * A setter for a User's password.
     * @param p The new password.
     */
    public void changePassword(String p)
    {
        this.password = p;
    }

    /**
     * Getter for a user's username.
     * @return  The user's current username.
     */
    public String getUsername()
    {
        return username;
    }

    /**
     * Getter for a user's password.
     * @return  The user's current password.
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * Getter for a user's balance.
     * @return  The user's current balance.
     */
    public float getBalance() {
        return balance;
    }

    /**
     * Getter for a user's watchlist.
     * @return  The user's watchlist.
     */
    public Set<Stock> getWatchlist() {
        return watchlist;
    }

    /**
     * Getter for the user's amountOwned HashMap.
     * @return  The user's HashMap.
     */
    public Map<Stock, Double> getAmountOwned() {
        return amountOwned;
    }

    /**
     * Getter for the user's remind buy price for the passed in stock.
     * @param i The stock to get the remind price of.
     * @return  The price the user should be reminded to purchase the stock.
     */
    public Double getRemindBuyPrice(Stock i) { return remindBuy.get(i); }

    /**
     * Getter for the user's remind sell price for the passed in stock.
     * @param i The stock to get the remind price of.
     * @return  The price the user should be reminded to sell the stock.
     */
    public Double getRemindSellPrice(Stock i) { return remindSell.get(i); }

    /**
     * Getter for the HashSet which contains the stocks that the user owns.
     * @return  The Hashset of stocks that the user owns.
     */
    public static Set<Stock> getOwnedSet() {
        return ownedSet;
    }

    /**
     * Adds a stock to the user's watchlist
     * @param s Stock to be added
     * @return Returns true if the stock was successfully added. Returns false otherwise.
     */
    public boolean watchStock(Stock s) {
        boolean added = watchlist.add(s);
        if (added)
            return true;
        System.out.println("Stock is already being watched.");
        return false;
    }

    /**
     * Removes a stock from the watchlist
     * @param s Stock to be removed
     * @return Returns true if removed, false otherwise.
     */
    public boolean watchRemove(Stock s) {
        boolean removed = watchlist.remove(s);
        if (removed) {
            remindBuy.remove(s);
            return true;
        }
        System.out.println("Stock was never watched in the first place.");
        return false;
    }

    /**
     * Purchases the inputted stock, reducing the user's balance. The purchase price of the stock is also stored.
     * @param s Stock to be purchased.
     * @param quantity The quantity of stock to be purchased.
     */
    public void buyStock (Stock s, double quantity) {
        boolean owns = amountOwned.containsKey(s);
        if (!owns) {
            watchlist.remove(s);
            amountOwned.put(s, quantity);
            ownedSet.add(s);
            balance -= s.getPrice() * quantity;
        }
        else {
            double amount = amountOwned.get(s);
            amount += quantity;
            amountOwned.put(s, amount);
            balance -= s.getPrice() * quantity;
        }
    }

    /**
     * Used to associate a buy price to a stock
     * @param s The stock to set a buy price to
     * @param price The price the stock should be bought
     */
    public void setBuyPrice(Stock s, double price) {
        remindBuy.put(s, price);
    }

    /**
     * Used to associate a sell price to a stock
     * @param s The stock to set a sell price to
     * @param price The price the stock should be sold
     */
    public void setSellPrice(Stock s, double price) {
        remindSell.put(s, price);
    }

    /**
     * Iterates through owned stocks and reminds the user to sell if the condition is met.
     * @return Returns true if stock should be sold, false otherwise
     */
    public boolean remindSell() {
        for (Stock stock : ownedSet) {
            if (stock.getPrice() >= remindSell.get(stock)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Iterates through watchlist stocks and reminds the user to purchase if a condition is met.
     * @return Returns true if the stock should be purchased
     */
    public boolean remindBuy() {
        for (Stock stock : watchlist) {
            if (stock.getPrice() <= remindBuy.get(stock)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Sells the user's owned stock, increasing their balance. Removes the stock from the owned stocks and stored purchase price.
     * @param s The stock to be sold.
     * @return Returns true if the stock was successfully sold. Returns false otherwise.
     */
    public boolean sellStock(Stock s, double quantity) {
        boolean owns = amountOwned.containsKey(s);
        if (owns) {
            double amount = amountOwned.get(s);
            if (quantity >= amount) {
                balance += s.getPrice() * amount;
                ownedSet.remove(s);
                amountOwned.remove(s);
                remindSell.remove(s);
                return true;
            }
            else {
                amount -= quantity;
                balance += s.getPrice() * quantity;
                amountOwned.put(s, amount);
                return true;
            }
        }
        else System.out.println("Stock could not be sold.");
        return false;
    }

    /**
     * Generates the hashcode based off the sum of the username's and password's hashcode.
     * @return  The sum of the username and password's hashcode.
     */
    @Override
    public int hashCode() {
        return username.hashCode() + password.hashCode();
    }

    /**
     * Compares the passed in object with this object for equality.
     * @param o The object to compare this to.
     * @return If the passed in object is an instance of User, and the password and username matches that of
     *         this User, returns true. Returns false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof User) {
            User that = (User)o;
            return this.password.equals(that.password) && this.username.equals(that.username);
        }
        return false;
    }
}
