package core;

import java.sql.*;

public class DBWorker {

    private final String URL = "jdbc:sqlite:src\\main\\resources\\SQLite\\password_manager.db";
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