package com.academy.fx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    private String user = "root";
    private String pw = "root";
    private String checkUser, checkPw;

    // view components
    @FXML
    private Label mailLbl;
    @FXML
    private Label passwordLbl;
    @FXML
    private TextField mailTxt;
    @FXML
    private PasswordField passwordTxt;
    @FXML
    private Button loginBtn;
    @FXML
    private Label msgLbl;
    @FXML
    private Button registerBtn;


    @FXML
    public void onClickLoginButton() {
        System.out.println("click login");
//            checkUser = loginPage.getUserName();
//            checkPw = loginPage.getPassword();
//            if (checkUser.equals(user) && checkPw.equals(pw)) {
//                loginPage.showMessage("Congratulations!");
//            } else {
//                loginPage.showError("Incorrect user or pw.");
//            }
//
//            loginPage.clearFields();
    }

    @FXML
    public void onClickRegisterButton() {
        System.out.println("click register");

//            Page registrationPage = new RegistrationPage();
//            registrationPage.init();
//            registrationPage.show();
//            loginPage.close();
    }
}
