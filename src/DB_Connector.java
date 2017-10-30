import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connector {

    // Declaring a Connection
    private static Connection con = null;

    // JDBC Driver
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    // the url =jdbc:mysql://host name:port#/db name
    public static String url= "jdbc:mysql://localhost:3306/";
    // user name
    private static String usr = "root";
    // pass word
    private static String pswrd = "030493";

    public static Connection connect() {
        System.out.println("\n--Connecting to MySQL JDBC");
        // Locate MySQL JDBC Driver
        try {
            Class.forName(DRIVER);
        }
        // Catch exceptions if JDBC is not found
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("\n--JDBC driver is missing--");

        }
        System.out.println("\n--MySQL JDBC driver registered--");

        try {
            // Connect to MySQL DB = URL, usrName, pswrd
            con = DriverManager.getConnection(url, usr, pswrd);
        }
        // Catch exceptions on conection error
        catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("\n--Did not connect try again--");
        }

        // if connection succesful
        if (con != null) {
            System.out.println("\n--Connection successful--");
        } else {
            System.out.println("\n--Failed to Connect--");
        }
        return con;
    }
}
