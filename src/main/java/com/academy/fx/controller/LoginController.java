package com.academy.fx.controller;

import com.academy.fx.model.User;
import com.academy.fx.page.PageFactory;
import com.academy.fx.service.UserService;
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

    private UserService userService;

    public LoginController() {
        userService = UserService.getInstance();
    }

    @FXML
    public void onClickLoginButton() {
        System.out.println("click login");
        String mail = mailTxt.getText();
        String password = passwordTxt.getText();

        if (mail == null || password == null || mail.isEmpty() || password.isEmpty() ||
                !isValid(mail, password)) {

        } else {
            User user = userService.getByEmail(mail);
            if (user == null) {

            } else {
                PageFactory.getLoginPage().hide();
                PageFactory.getRegistrationPage().show();
            }
        }
    }

    @FXML
    public void onClickRegisterButton() {
        System.out.println("click register");

        PageFactory.getLoginPage().hide();
        PageFactory.getRegistrationPage().show();
    }

    private boolean isValid(String mail, String password) {
        return true;
    }
}
