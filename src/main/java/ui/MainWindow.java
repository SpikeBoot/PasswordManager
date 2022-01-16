package ui;


import core.PasswordBase;
import ui.listOfServices.PanelOfListServices;
import ui.passwordScreen.PanelOfPasswords;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private PanelOfListServices panelOfListServices;
    private PanelOfPasswords panelOfPasswords;

//    This only one Password Base
    private PasswordBase passwordBase = new PasswordBase();

    public MainWindow() {
//        Settings of main window
        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(600, 400));
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Password manager");
        this.setLocationRelativeTo(null);
        this.setIconImage((new ImageIcon("./src/main/resources/icons/lock.png")).getImage());


//        Initialisation inner panels and transfer reference on Password Base
        panelOfListServices = new PanelOfListServices(passwordBase);
        panelOfPasswords = new PanelOfPasswords(passwordBase);

//        Transfer object PanelOfViewPassword for access from PanelOfListServices
        panelOfListServices.setPanelOfViewPassword(panelOfPasswords.getPanelOfViewPassword());
//        Transfer object PanelOfViewPassword for access from PanelOfListServices
        panelOfPasswords.getPanelOfViewPassword().setPanelOfListServices(panelOfListServices);
        panelOfPasswords.getPanelOfNewPassword().setPanelOfListServices(panelOfListServices);

        this.add(panelOfListServices, BorderLayout.WEST);
        this.add(panelOfPasswords, BorderLayout.CENTER);
        this.setVisible(true);
    }
}
