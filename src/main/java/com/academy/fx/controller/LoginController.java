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


    public EventHandler<ActionEvent> onClickLoginButton(TextField userNameField, TextField passwordField, Label msgLabel) {
        return event -> {
            checkUser = userNameField.getText();
            checkPw = passwordField.getText();
            if (checkUser.equals(user) && checkPw.equals(pw)) {
                msgLabel.setText("Congratulations!");
                msgLabel.setTextFill(Color.GREEN);
            } else {
                msgLabel.setText("Incorrect user or pw.");
                msgLabel.setTextFill(Color.RED);
            }
            userNameField.setText("");
            passwordField.setText("");
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
