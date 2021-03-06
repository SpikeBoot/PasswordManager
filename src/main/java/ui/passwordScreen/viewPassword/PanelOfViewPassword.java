package ui.passwordScreen.viewPassword;

import core.PasswordBase;
import core.PasswordCard;
import ui.listOfServices.PanelOfListServices;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelOfViewPassword extends JPanel {
    private PasswordBase passwordBase;
    private PasswordCard passwordCard;
    private int currentPasswordCardsIndex;

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

    private JButton editButton;
    private JButton saveButton;
    private JButton deleteButton;

    private ArrayList<JLabel> labels = new ArrayList<>();
    private ArrayList<JTextField> textFields = new ArrayList<>();
    private ArrayList<JButton> buttons = new ArrayList<>();

    public PanelOfViewPassword(PasswordBase passBase) {
        this.setLayout(null);

//        Init PasswordBase
        this.passwordBase = passBase;

        this.initLabels();
        this.initTextFields();
        this.initButtons();

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
        editButton = new JButton();
        saveButton = new JButton();
        deleteButton = new JButton();

        editButton.setIcon(new ImageIcon("./src/main/resources/icons/edit.png"));
        saveButton.setIcon(new ImageIcon("./src/main/resources/icons/save.png"));
        deleteButton.setIcon(new ImageIcon("./src/main/resources/icons/delete.png"));

        editButton.addActionListener(e -> {
            editPasswordCard(passwordCard);
            panelOfListServices.repaint();
        });

        saveButton.addActionListener(e -> {
            passwordBase.writePasswordBase();
        });

        deleteButton.addActionListener(e -> {
            passwordBase.getListOfPasswordCards().remove(currentPasswordCardsIndex);
            panelOfListServices.updateListOfServices();

            for(JTextField textField: textFields){
                textField.setText("");
            }
        });

        buttons.add(editButton);
        buttons.add(saveButton);
        buttons.add(deleteButton);

        for (int i = 0; i < buttons.size(); i++) {
            buttons.get(i).setBorderPainted(true);
            buttons.get(i).setFocusPainted(false);
            buttons.get(i).setContentAreaFilled(false);
            buttons.get(i).setSize(50, 50);
            buttons.get(i).setLocation(new Point(i * 100 + 80, 230));
            this.add(buttons.get(i));
        }
    }

    public void viewPasswordCard(PasswordCard passwordCard) {
        this.passwordCard = passwordCard;
        textFieldOfServiceName.setText(passwordCard.getServiceName());
        textFieldOfEmail.setText(passwordCard.getEmail());
        textFieldOfPass.setText(passwordCard.getPass());
        textFieldOfRecoveryCode.setText(passwordCard.getRecoveryCode());
        textFieldOfSecretQuestion.setText(passwordCard.getSecretQuestion());
        textFieldOfSecretQuestionAnswer.setText(passwordCard.getSecretQuestionAnswer());
        textFieldOfDescription.setText(passwordCard.getDescription());
    }

    public void editPasswordCard(PasswordCard passwordCard) {
        passwordCard.setServiceName(textFieldOfServiceName.getText());
        passwordCard.setEmail(textFieldOfEmail.getText());
        passwordCard.setPass(textFieldOfPass.getText());
        passwordCard.setRecoveryCode(textFieldOfRecoveryCode.getText());
        passwordCard.setSecretQuestion(textFieldOfSecretQuestion.getText());
        passwordCard.setSecretQuestionAnswer(textFieldOfSecretQuestionAnswer.getText());
        passwordCard.setDescription(textFieldOfDescription.getText());
    }

    public void setCurrentPasswordCardsIndex(int currentPasswordCardsIndex) {
        this.currentPasswordCardsIndex = currentPasswordCardsIndex;
    }

    public void setPanelOfListServices(PanelOfListServices panelOfListServices) {
        this.panelOfListServices = panelOfListServices;
    }
}
