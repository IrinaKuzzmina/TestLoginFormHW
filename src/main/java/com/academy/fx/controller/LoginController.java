package com.academy.fx.controller;

import com.academy.fx.model.AuthForm;
import com.academy.fx.model.User;
import com.academy.fx.page.PageFactory;
import com.academy.fx.service.UserService;
import com.academy.fx.validator.AuthValidator;
import com.academy.fx.validator.Validator;
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
    private Validator<AuthForm> authValidator = new AuthValidator();

    public LoginController() {
        userService = UserService.getInstance();
    }

    @FXML
    public void onClickLoginButton() {
        System.out.println("click login");

        AuthForm form = new AuthForm()
                .withEmail(mailLbl.getText().replace(":", ""), mailTxt.getText())
                .withPassword(passwordLbl.getText().replace(":", ""), passwordTxt.getText());

        if (!authValidator.validate(form)) {
            clearFields();
            showError(authValidator.getMsgError());
        } else {
            PageFactory.getLoginPage().hide();
            PageFactory.getRegistrationPage().show();
        }
    }

    private void showError(String msgError) {
        msgLbl.setText(msgError);
    }

    private void clearFields() {
        mailTxt.setText("");
        passwordTxt.setText("");
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
