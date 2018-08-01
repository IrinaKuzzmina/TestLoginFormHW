package com.academy.fx.controller;

import com.academy.fx.model.AuthForm;
import com.academy.fx.page.PageFactory;
import com.academy.fx.validator.AuthValidator;
import com.academy.fx.validator.Validator;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
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
    private Label msgLbl;

    private Validator<AuthForm> authValidator = new AuthValidator();

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
            PageFactory.getAccountPage(mailTxt.getText()).show();
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
    public void onClickRegisterLink() {
        System.out.println("click register");

        PageFactory.getLoginPage().hide();
        PageFactory.getRegistrationPage().show();
    }
}
