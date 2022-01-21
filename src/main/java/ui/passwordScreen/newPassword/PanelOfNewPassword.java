package ui.passwordScreen.newPassword;

import core.PasswordCardsContainer;
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

    private ArrayList<JLabel> labels = new ArrayList<>();
    private ArrayList<JTextField> textFields = new ArrayList<>();

    public PanelOfNewPassword(PasswordCardsContainer passwordCardsContainer) {
        this.setLayout(null);

        this.passwordCardsContainer = passwordCardsContainer;

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

        addButton.setIcon(new ImageIcon("./src/main/resources/icons/add.png"));

        addButton.addActionListener(e -> {
            if (!textFieldOfServiceName.getText().trim().equals("")) {

                passwordCardsContainer.createPasswordCard(
                        textFieldOfServiceName.getText(),
                        textFieldOfEmail.getText(),
                        textFieldOfPass.getText(),
                        textFieldOfRecoveryCode.getText(),
                        textFieldOfSecretQuestion.getText(),
                        textFieldOfSecretQuestionAnswer.getText(),
                        textFieldOfDescription.getText());

                for (JTextField textField : textFields) {
                    textField.setText("");
                }
            }
            panelOfListServices.updateListOfServices();
        });

        addButton.setBorderPainted(true);
        addButton.setFocusPainted(false);
        addButton.setContentAreaFilled(false);
        addButton.setSize(50, 50);
        addButton.setLocation(new Point(180, 230)); // change position
        this.add(addButton);

    }

    public void setPanelOfListServices(PanelOfListServices panelOfListServices) {
        this.panelOfListServices = panelOfListServices;
    }
}
