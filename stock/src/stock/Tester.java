package stock;
import java.io.IOException;
import java.util.*;

public class Tester {

    public static void main(String[] args) throws IOException {
        Database base = new Database();

        ArrayList<DataPoint> data = base.getData();

        for (DataPoint x: data)
        {
            System.out.println(x.getDate());
        }
    }
}