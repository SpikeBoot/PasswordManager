package core;

import java.sql.*;

public class DBWorker {

    private final String URL = "jdbc:sqlite:password_base.db";
    private Connection connection;

    DBWorker (){
        try{
            Class.forName("org.sqlite.JDBC");
            System.out.println("Driver was register");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        try{
            connection = DriverManager.getConnection(URL);
            System.out.println("Connection is fine");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }

}

//class Test{
//    public static void main(String[] args) {
//        DBWorker db = new DBWorker("jdbc:sqlite:password_base.db");
//        db.getConnection();
//    }
//}