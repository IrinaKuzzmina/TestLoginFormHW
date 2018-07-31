package com.academy.fx.controller;

import com.academy.fx.validator.EmailValidator;
import com.academy.fx.validator.NameValidator;
import com.academy.fx.validator.PasswordValidator;
import com.academy.fx.validator.Validator;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class RegistrationController {
    private Validator nameValidator = new NameValidator();
    private Validator passwordValidator = new PasswordValidator();
    private Validator emailValidator = new EmailValidator();

    // view components
    @FXML
    private Label firstNameLbl;
    @FXML
    private Label lastNameLbl;
    @FXML
    private Label mailLbl;
    @FXML
    private Label passwordLbl;
    @FXML
    private Label confPasswordLbl;

    @FXML
    private TextField firstNameTxt;
    @FXML
    private TextField lastNameTxt;
    @FXML
    private TextField mailTxt;
    @FXML
    private PasswordField passwordTxt;
    @FXML
    private PasswordField confPasswordTxt;

    @FXML
    private Label msgLbl;
    @FXML
    private Button registerBtn;

    @FXML
    public void onClickRegisterButton() {

        if (!nameValidator.validate(firstNameLbl.getText().replace(":", ""), firstNameTxt.getText())) {
            showError(nameValidator.getMsgError());
            return;
        }

        if (!nameValidator.validate(lastNameLbl.getText().replace(":", ""), lastNameTxt.getText())) {
            showError(nameValidator.getMsgError());
            return;
        }

        if (!emailValidator.validate(mailLbl.getText().replace(":", ""), mailTxt.getText())) {
            showError(emailValidator.getMsgError());
            return;
        }

        if (!passwordValidator.validate(passwordLbl.getText().replace(":", ""), passwordTxt.getText())){
            showError(passwordValidator.getMsgError());
            clearPasswordFields();
            return;
        }

        if (!passwordTxt.getText().equals(confPasswordTxt.getText())) {
            showError("Not equals passwords");
            clearPasswordFields();
            return;
        }

        clearFields();
        showMessage("Congratulations!");
    }

    public void clearFields() {
        firstNameTxt.setText("");
        lastNameTxt.setText("");
        mailTxt.setText("");
        passwordTxt.setText("");
        confPasswordTxt.setText("");
    }

    public void clearPasswordFields() {
        passwordTxt.setText("");
        confPasswordTxt.setText("");
    }

    public void showError(String msg) {
        msgLbl.setText(msg);
        msgLbl.setTextFill(Color.ORANGE);
    }

    public void showMessage(String msg) {
        msgLbl.setText(msg);
        msgLbl.setTextFill(Color.GREEN);
    }
}
