package com.example.csproject.stock;

/**
 * A DataPoint object that represents a stock's opening, closing, and volume for a specified date.
 */
public class DataPoint {

    private String date;
    private double open;
    private double close;
    private int volume;

    /**
     * DataPoint Constructor that takes in the date, the stock's opening price, the stock's closing price, and the
     * volume of the stock.
     * @param date  The date of the Stock this DataPoint represents.
     * @param open  The opening price of the stock on that day.
     * @param close The closing price of the stock.
     * @param volume    The volume of the stock at closing.
     */
    public DataPoint(String date, double open, double close, int volume)
    {
        this.date = date;
        this.open = open;
        this.close = close;
        this.volume = volume;
    }

    /**
     * Getter for the date
     * @return  Returns the DataPoint's date.
     */
    public String getDate()
    {
        return date;
    }

    /**
     * Getter for the opening value.
     * @return  Returns the DataPoint's opening value.
     */
    public double getOpen()
    {
        return open;
    }

    /**
     * Getter for the closing value.
     * @return  Returns the DataPoint's closing value.
     */
    public double getClose()
    {
        return close;
    }

    /**
     * Getter for the closing volume.
     * @return  Returns the DataPoint's volume.
     */
    public int getVolume()
    {
        return volume;
    }
}
