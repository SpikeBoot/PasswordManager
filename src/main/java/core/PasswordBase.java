package core;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class PasswordBase {
    private ArrayList<PasswordCard> listOfPasswordCards;


    public PasswordBase() {
        listOfPasswordCards = this.readPasswordBase();
    }

    public ArrayList<PasswordCard> readPasswordBase() {
        ArrayList<PasswordCard> arrayListOfPasswordCard = new ArrayList<PasswordCard>();
        String sourceStringPasswordBase = "";

        try (FileReader reader = new FileReader("./src/main/resources/passwordbase.txt")) {
            while(reader.ready()){
                sourceStringPasswordBase += (char) reader.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String [] arrayOfStringPasswordCard = sourceStringPasswordBase.split("<card>");

        for (int i = 0; i < arrayOfStringPasswordCard.length - 1; i++) {
            arrayListOfPasswordCard.add(PasswordCard.transferFromString(arrayOfStringPasswordCard[i]));
        }
        Collections.sort(arrayListOfPasswordCard);
        return arrayListOfPasswordCard;
    }

    public void writePasswordBase(){
        try(FileWriter writer = new FileWriter("./src/main/resources/passwordbase.txt")){
            for (PasswordCard passwordCard: listOfPasswordCards){
                writer.write(passwordCard.transferToString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<PasswordCard> getListOfPasswordCards() {
        return listOfPasswordCards;
    }
}