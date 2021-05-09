package stock;

public class User {

    String username;
    String password;


    public User(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    public void changeUsername(String u)
    {
        this.username = u;
    }

    public void changePassword(String p)
    {
        this.password = p;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    /*
    public Stock[] getData()
    {
        return database.accessData(User u);
    }

     */
}

