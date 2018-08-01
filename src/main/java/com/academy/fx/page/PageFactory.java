package com.academy.fx.page;

import javafx.stage.Stage;

public class PageFactory {

    private static LoginPage loginPage;
    private static RegistrationPage registrationPage;

    public static LoginPage getLoginPage(Stage primaryStage) {
        synchronized (LoginPage.class) {
            if (loginPage == null) {
                loginPage = new LoginPage(primaryStage);
                loginPage.init();
            }
        }
        return loginPage;
    }

    public static LoginPage getLoginPage() {
        synchronized (LoginPage.class) {
            if (loginPage == null) {
                loginPage = new LoginPage();
                loginPage.init();
            }
        }
        return loginPage;
    }

    public static RegistrationPage getRegistrationPage() {
        synchronized (RegistrationPage.class) {
            if (registrationPage == null) {
                registrationPage = new RegistrationPage();
                registrationPage.init();
            }
        }
        return registrationPage;
    }
}
