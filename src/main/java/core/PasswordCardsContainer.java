package core;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

public class PasswordCardsContainer {

    private DBWorker dbWorker;
    private ArrayList<PasswordCard> listOfPasswordCards;

    public PasswordCardsContainer() {
        this.dbWorker = new DBWorker();
        this.readPasswordBase();
    }

    public void readPasswordBase() {
        ArrayList<PasswordCard> arrayListOfPasswordCard = new ArrayList<>();

        try (Connection connection = dbWorker.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM password_cards");

            while (resultSet.next()) {
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
        listOfPasswordCards = arrayListOfPasswordCard;
    }

    public void createPasswordCard(String serviceName,
                                   String email,
                                   String pass,
                                   String recoveryCode,
                                   String secretQuestion,
                                   String secretQuestionAnswer,
                                   String description) {

        try (Connection connection = dbWorker.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO password_cards(serviceName, email, pass, recoveryCode, " +
                             "secretQuestion, secretQuestionAnswer, description) VALUES (?, ?, ?, ?, ?, ?, ?)")
        ) {

            preparedStatement.setString(1, serviceName);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, pass);
            preparedStatement.setString(4, recoveryCode);
            preparedStatement.setString(5, secretQuestion);
            preparedStatement.setString(6, secretQuestionAnswer);
            preparedStatement.setString(7, description);

            preparedStatement.execute();

            readPasswordBase();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void editPasswordCard(int id,
                                 String serviceName,
                                 String email,
                                 String pass,
                                 String recoveryCode,
                                 String secretQuestion,
                                 String secretQuestionAnswer,
                                 String description) {

        try (Connection connection = dbWorker.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE password_cards SET serviceName = ?, email = ?, pass = ?, " +
                             "recoveryCode = ?, secretQuestion = ?, secretQuestionAnswer = ?, " +
                             "description = ? WHERE id = ?")) {

            preparedStatement.setString(1, serviceName);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, pass);
            preparedStatement.setString(4, recoveryCode);
            preparedStatement.setString(5, secretQuestion);
            preparedStatement.setString(6, secretQuestionAnswer);
            preparedStatement.setString(7, description);
            preparedStatement.setInt(8, id);

            preparedStatement.execute();

            readPasswordBase();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void removePasswordCard(int id){

        try(Connection connection = dbWorker.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM password_cards WHERE id = ?")){

            preparedStatement.setInt(1, id);

            preparedStatement.execute();

            readPasswordBase();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public ArrayList<PasswordCard> getListOfPasswordCards() {
        ArrayList<PasswordCard> arrayListOfPasswordCards = new ArrayList<>(listOfPasswordCards);
        return arrayListOfPasswordCards;
    }
}