package stock;

public class DataPoint {

    private String date;
    private double open;
    private double close;
    private int volume;

    public DataPoint(String date, double open, double close, int volume)
    {
        this.date = date;
        this.open = open;
        this.close = close;
        this.volume = volume;
    }

    public String getDate()
    {
        return date;
    }

    public double getOpen()
    {
        return open;
    }

    public double getClose()
    {
        return close;
    }

    public int getVolume()
    {
        return volume;
    }
}
