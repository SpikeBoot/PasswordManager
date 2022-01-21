package ui.passwordScreen;

import core.PasswordCardsContainer;
import ui.passwordScreen.newPassword.PanelOfNewPassword;
import ui.passwordScreen.viewPassword.PanelOfViewPassword;

import javax.swing.*;

public class PanelOfPasswords extends JTabbedPane {
    private PanelOfViewPassword panelOfViewPassword;
    private PanelOfNewPassword panelOfNewPassword;

    public PanelOfPasswords(PasswordCardsContainer passBase){
        panelOfViewPassword = new PanelOfViewPassword(passBase);
        panelOfNewPassword = new PanelOfNewPassword(passBase);

        this.addTab("Show Password card", panelOfViewPassword);
        this.addTab("Create Password card", panelOfNewPassword);
    }

    public PanelOfViewPassword getPanelOfViewPassword() {
        return panelOfViewPassword;
    }

    public PanelOfNewPassword getPanelOfNewPassword() {
        return panelOfNewPassword;
    }
}
