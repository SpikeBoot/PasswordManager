package ui.listOfServices;

import core.PasswordCardsContainer;
import core.PasswordCard;
import ui.passwordScreen.viewPassword.PanelOfViewPassword;

import javax.swing.*;
import java.awt.*;

public class PanelOfListServices extends JPanel {
    private PasswordCardsContainer passwordCardsContainer;
    private JList<PasswordCard> listOfServices;
    private DefaultListModel<PasswordCard> defaultListModel = new DefaultListModel<>();
    private PanelOfViewPassword panelOfViewPassword;

    public PanelOfListServices(PasswordCardsContainer passBase) {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(150, 0));

//      Initialization passwordCardsContainer and listOfServices
        this.passwordCardsContainer = passBase;
        this.createListOfServices();

//      Adding List of Service
        this.add(new JScrollPane(listOfServices), BorderLayout.CENTER);
    }

//    Only create JList and add SelectListener
    public void createListOfServices() {
        listOfServices = new JList();
        listOfServices.setFont(new Font("", Font.BOLD, 14));
        listOfServices.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.updateListOfServices();

        listOfServices.addListSelectionListener(e -> {
            if (listOfServices.getValueIsAdjusting()) {
                panelOfViewPassword.viewPasswordCard(passwordCardsContainer.getListOfPasswordCards().get(listOfServices.getSelectedIndex()));
                panelOfViewPassword.setCurrentPasswordCardsIndex(listOfServices.getSelectedIndex());
            }
        });
    }

//    Update all elements in JList
    public void updateListOfServices() {
        defaultListModel.clear();
        for (PasswordCard passwordCard : passwordCardsContainer.getListOfPasswordCards()) {
            defaultListModel.addElement(passwordCard);
        }
        listOfServices.setModel(defaultListModel);
        listOfServices.validate();
    }

    public void setPanelOfViewPassword(PanelOfViewPassword panelOfViewPassword) {
        this.panelOfViewPassword = panelOfViewPassword;
    }
}
