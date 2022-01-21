package core;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

public class PasswordCardsContainer {

    private DBWorker dbWorker;
    private ArrayList<PasswordCard> listOfPasswordCards;


    public PasswordCardsContainer() {
        this.dbWorker = new DBWorker();
        listOfPasswordCards = this.readPasswordBase();
    }

    public ArrayList<PasswordCard> readPasswordBase() {
        ArrayList<PasswordCard> arrayListOfPasswordCard = new ArrayList<>();

        try(Connection connection = dbWorker.getConnection();
            Statement statement = connection.createStatement()){

            ResultSet resultSet = statement.executeQuery("SELECT * FROM password_cards;");

            while(resultSet.next()){
                arrayListOfPasswordCard.add(new PasswordCard(
                        resultSet.getInt("id"),
                        resultSet.getString("serviceName"),
                        resultSet.getString("email"),
                        resultSet.getString("pass"),
                        resultSet.getString("recoveryCode"),
                        resultSet.getString("secretQuestion"),
                        resultSet.getString("secretQuestionAnswer"),
                        resultSet.getString("description")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        Collections.sort(arrayListOfPasswordCard);
        return arrayListOfPasswordCard;
    }

    public ArrayList<PasswordCard> getListOfPasswordCards() {
        return listOfPasswordCards;
    }
}