public class TestDB_Connector {
    public static void main(String[] args) {
        //Connection con = DB_Connector.connect();
        DB_Statements stmts = new DB_Statements();

        //statements method to create a new database
        //stmts.createNewDB();

        //statemtns method to use database
        stmts.useDB("ThisDatabase");

        //statements method to create a table in database
        //stmts.createTable("MyTable");

        //statements method to insert data into table of database
        //stmts.insertData("MyTable");

        //statements method to select data from table
        stmts.selectFromTable("MyTable");

    }
}
