package com.example.csproject.stock;

public class Stock {

    String symbol;
    double price;
    String name;
    int volume;

    /**
     * Stock object
     * @param symbol stock symbol
     * @param name stock name
     * @param price stock price
     * @param volume stock volume
     */
    public Stock (String symbol, String name, double price, int volume)
    {
        this.symbol = symbol;
        this.name = name;
        this.price = price;
        this.volume = volume;
    }

    /**
     * updates stock price
     * @param m the updated price
     */
    public void updatePrice(Float m)
    {
        this.price = m;
    }

    /**
     * updates the symbol of Stock
     * @param s the updated symbol
     */
    public void updateSymbol(String s)
    {
        this.symbol = s;
    }

    /**
     * updates name of stock
     * @param n the updated stock name
     */
    public void updateName(String n)
    {
        this.name = name;
    }

    /**
     * getter for stock price
     * @return double the stock price
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * getter for stock symbol
     * @return string the symbol
     */
    public String getSymbol()
    {
        return symbol;
    }

    /**
     * getter for stock name
     * @return string the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * updates volume
     * @param v updated volume
     */
    public void updateVolume(int v)
    {
        this.volume = v;
    }

    /**
     *
     * @return
     */
    public int getVolume()
    {
        return volume;
    }
}
