package ui.passwordScreen.newPassword;

import core.PasswordCardsContainer;
import core.PasswordCard;
import ui.listOfServices.PanelOfListServices;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelOfNewPassword extends JPanel {
    private PasswordCardsContainer passwordCardsContainer;

    private PanelOfListServices panelOfListServices;

    private JLabel labelOfServiceName;
    private JLabel labelOfEmail;
    private JLabel labelOfPass;
    private JLabel labelOfRecoveryCode;
    private JLabel labelOfSecretQuestion;
    private JLabel labelOfSecretQuestionAnswer;
    private JLabel labelOfDescription;

    private JTextField textFieldOfServiceName;
    private JTextField textFieldOfEmail;
    private JTextField textFieldOfPass;
    private JTextField textFieldOfRecoveryCode;
    private JTextField textFieldOfSecretQuestion;
    private JTextField textFieldOfSecretQuestionAnswer;
    private JTextField textFieldOfDescription;

    private JButton addButton;
    private JButton saveButton;

    private ArrayList<JLabel> labels = new ArrayList<>();
    private ArrayList<JTextField> textFields = new ArrayList<>();
    private ArrayList<JButton> buttons = new ArrayList<>();

    public PanelOfNewPassword(PasswordCardsContainer passBase){
        this.setLayout(null);

        this.passwordCardsContainer = passBase;

        initLabels();
        initTextFields();
        initButtons();
    }

    private void initLabels() {
        labelOfServiceName = new JLabel("Name of service:");
        labelOfEmail = new JLabel("Email:");
        labelOfPass = new JLabel("Password:");
        labelOfRecoveryCode = new JLabel("Recovery code:");
        labelOfSecretQuestion = new JLabel("Secret question:");
        labelOfSecretQuestionAnswer = new JLabel("Answer on question:");
        labelOfDescription = new JLabel("Description:");

        labels.add(labelOfServiceName);
        labels.add(labelOfEmail);
        labels.add(labelOfPass);
        labels.add(labelOfRecoveryCode);
        labels.add(labelOfSecretQuestion);
        labels.add(labelOfSecretQuestionAnswer);
        labels.add(labelOfDescription);

        for (int i = 0; i < labels.size(); i++) {
            labels.get(i).setFont(new Font("", Font.BOLD, 14));
            labels.get(i).setSize(new Dimension(150, 25));
            labels.get(i).setLocation(new Point(10, i * 25 + 10));
            this.add(labels.get(i));
        }
    }

    private void initTextFields() {
        textFieldOfServiceName = new JTextField();
        textFieldOfEmail = new JTextField();
        textFieldOfPass = new JTextField();
        textFieldOfRecoveryCode = new JTextField();
        textFieldOfSecretQuestion = new JTextField();
        textFieldOfSecretQuestionAnswer = new JTextField();
        textFieldOfDescription = new JTextField();

        textFields.add(textFieldOfServiceName);
        textFields.add(textFieldOfEmail);
        textFields.add(textFieldOfPass);
        textFields.add(textFieldOfRecoveryCode);
        textFields.add(textFieldOfSecretQuestion);
        textFields.add(textFieldOfSecretQuestionAnswer);
        textFields.add(textFieldOfDescription);

        for (int i = 0; i < textFields.size(); i++) {
            textFields.get(i).setFont(new Font("", Font.PLAIN, 14));
            textFields.get(i).setSize(new Dimension(250, 22));
            textFields.get(i).setLocation(new Point(170, i * 25 + 12));
            this.add(textFields.get(i));
        }
    }

    private void initButtons() {
        addButton = new JButton();
        saveButton = new JButton();


        addButton.setIcon(new ImageIcon("./src/main/resources/icons/add.png"));
        saveButton.setIcon(new ImageIcon("./src/main/resources/icons/save.png"));


        addButton.addActionListener(e -> {
            createNewPasswordCard();
            panelOfListServices.updateListOfServices();
        });

        saveButton.addActionListener(e -> {
            passwordCardsContainer.writePasswordBase();
        });

        buttons.add(addButton);
        buttons.add(saveButton);

        for (int i = 0; i < buttons.size(); i++) {
            buttons.get(i).setBorderPainted(true);
            buttons.get(i).setFocusPainted(false);
            buttons.get(i).setContentAreaFilled(false);
            buttons.get(i).setSize(50, 50);
            buttons.get(i).setLocation(new Point(i * 100 + 140, 230));
            this.add(buttons.get(i));
        }
    }

    private void createNewPasswordCard(){
        if(!textFieldOfServiceName.getText().trim().equals("")){
            passwordCardsContainer.getListOfPasswordCards().add(new PasswordCard(
                    textFieldOfServiceName.getText(),
                    textFieldOfEmail.getText(),
                    textFieldOfPass.getText(),
                    textFieldOfRecoveryCode.getText(),
                    textFieldOfSecretQuestion.getText(),
                    textFieldOfSecretQuestionAnswer.getText(),
                    textFieldOfDescription.getText()));
            for(JTextField textField: textFields){
                textField.setText("");
            }
        }
    }

    public void setPanelOfListServices(PanelOfListServices panelOfListServices) {
        this.panelOfListServices = panelOfListServices;
    }
}
