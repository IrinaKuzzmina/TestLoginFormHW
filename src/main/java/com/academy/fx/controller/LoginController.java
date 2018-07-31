package com.academy.fx.controller;

import com.academy.fx.page.LoginPage;
import com.academy.fx.page.Page;
import com.academy.fx.page.RegistrationPage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class LoginController {
    private String user = "root";
    private String pw = "root";
    private String checkUser, checkPw;


    public EventHandler<ActionEvent> onClickLoginButton(LoginPage loginPage) {
        return event -> {
            checkUser = loginPage.getUserName();
            checkPw = loginPage.getPassword();
            if (checkUser.equals(user) && checkPw.equals(pw)) {
                loginPage.showMessage("Congratulations!");
            } else {
                loginPage.showError("Incorrect user or pw.");
            }

            loginPage.clearFields();
        };
    }

    public EventHandler<MouseEvent> onClickRegisterButton(LoginPage loginPage) {
        return event -> {
            Page registrationPage = new RegistrationPage();
            registrationPage.init();
            registrationPage.show();
            loginPage.close();
        };
    }
}
