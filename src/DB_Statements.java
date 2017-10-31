import java.sql.*;

/*DDL - Create, update, modify, delete*/
// 1. SQL statement
// 2. Connection
// 3. execute query/statement
// 4. result set

public class DB_Statements {

    //Declare a Statement
    private static Statement stmt = null;
    //Declare a connection
    private static Connection con = DB_Connector.connect();
    //Declare a result set
    private static ResultSet rs = null;

    //Method to create a new Database
    public void createNewDB(String DB_Name) {
        //SQL statement
        String query = "CREATE database if NOT EXISTS " + DB_Name;

        try {
            //Connection
            stmt = con.createStatement();
            //Execute statement
            stmt.executeUpdate(query);
            System.out.println("\n--Database " + DB_Name + " created--");
        } catch (SQLException ex) {
            //Handle SQL exceptions
            System.out.println("\n--Statement did not execute--");
            ex.printStackTrace();
        }
    }

    //Method to use a database
    public void useDB(String DB_Name) {
        //SQL statement
        String query = "USE " + DB_Name;
        try {
            //connection
            stmt = con.createStatement();
            //execute query
            stmt.executeUpdate(query);
            System.out.println("\n--using " + DB_Name + "--");
        } catch (SQLException ex) {
            //Handle SQL exceptions
            System.out.println("\n--Query did not execute--");
            ex.printStackTrace();
        }
    }

    //Method to create a table
    public void createTable(String tableName) {
        //SQL Statement
        String query = "CREATE TABLE if NOT EXISTS " + tableName +
                "(" +
                "id INT NOT NULL auto_increment, " +
                "myName VARCHAR (28), " +
                "address VARCHAR (28), " +
                "PRIMARY KEY (id)" +
                ")";

        try {
            //connection
            stmt = con.createStatement();
            //execute query
            stmt.executeUpdate(query);
            System.out.println("\n--Table " + tableName + " created--");
        } catch (SQLException ex) {
            System.out.println("\n--Query did not execute--");
            ex.printStackTrace();
        }
    }

    //Method to insert data into table
    public void insertData(String tableName) {
        //SQL statement
        String query = "insert into " + tableName +
                "(" +
                "myName, address) " +
                "values ('Michael', 'my adress'), " +
                "('Nanna', 'Her adress'), " +
                "('Mathias', 'Their adress'), " +
                "('Maja', 'Their adress')";

        try {
            //connection
            stmt = con.createStatement();
            //execute query
            stmt.executeUpdate(query);
            System.out.println("\n--Data inserted into table " + tableName + "--");
        } catch (SQLException ex) {
            //Handle SQL exceptions
            System.out.println("\n--Query did not execute--");
            ex.printStackTrace();
        }
    }

    //Method to read data from table
    public void selectFromTable(String tableName){
        //SQL query
        String query = "SELECT * FROM " + tableName;

        try {
            //connection
            stmt = con.createStatement();
            //execute query
            rs = stmt.executeQuery(query);
            System.out.println("\nid\t\tmyName\t\taddress\n____________________________________");

            //get data
            while (rs.next()){
                int id = rs.getInt(1); //returns the id / first column
                String myName = rs.getString("myName"); //returns my name
                String address = rs.getString("address"); //returns my name
                System.out.println(id + "\t\t" + myName + "\t\t" + address);
            }
        }
        catch (SQLException ex){
            System.out.println("\n--Query did not execute--");
            ex.printStackTrace();
        }
    }

    public Boolean checkLogin(String username, String password){
        boolean check = false;

        String query = "SELECT * FROM thisdatabase.user " +
                       "WHERE username = '" + username + "' " +
                       "AND password = '" + password + "' ";
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()){
                check = true;
                System.out.println("\n--It works!--");
            }
        }
        catch (SQLException e){
            System.out.println("\n--Dammit.. it doesn't work");
            e.printStackTrace();
        }
        return check;
    }
}
