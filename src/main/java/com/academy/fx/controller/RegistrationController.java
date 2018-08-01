package com.academy.fx.controller;

import com.academy.fx.model.RegistrationForm;
import com.academy.fx.model.User;
import com.academy.fx.page.PageFactory;
import com.academy.fx.service.UserService;
import com.academy.fx.validator.RegistrationValidator;
import com.academy.fx.validator.Validator;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegistrationController {
    private Validator<RegistrationForm> formValidator = new RegistrationValidator();

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

    private UserService userService = UserService.getInstance();

    @FXML
    public void onClickRegisterButton() {

        if (!formValidator.validate(prepareForm())) {
            clearPasswordFields();
            showError(formValidator.getMsgError());
            return;
        }

        User user = User.newUser()
                .withFirstName(firstNameTxt.getText().trim())
                .withLastName(lastNameTxt.getText().trim())
                .withMail(mailTxt.getText().trim())
                .withPassword(passwordTxt.getText().trim())
                .build();

        userService.save(user);

        clearFields();
        PageFactory.getRegistrationPage().hide();
        PageFactory.getAdminPage().show();
    }

    public void onClickLoginLink() {
        System.out.println("Click login link");
        PageFactory.getRegistrationPage().hide();
        PageFactory.getLoginPage().show();
    }

    public void onClickAdminLink() {
        PageFactory.getRegistrationPage().hide();
        PageFactory.getAdminPage().show();
    }

    private RegistrationForm prepareForm() {
        return new RegistrationForm()
                .withFirstName(firstNameLbl.getText().replace(":", ""), firstNameTxt.getText())
                .withLastName(lastNameLbl.getText().replace(":", ""), lastNameTxt.getText())
                .withMail(mailLbl.getText().replace(":", ""), mailTxt.getText())
                .withPassword(passwordLbl.getText().replace(":", ""), passwordTxt.getText())
                .withConfirmPassword(confPasswordLbl.getText().replace(":", ""), confPasswordTxt.getText());
    }

    private void clearFields() {
        firstNameTxt.setText("");
        lastNameTxt.setText("");
        mailTxt.setText("");
        passwordTxt.setText("");
        confPasswordTxt.setText("");
    }

    private void clearPasswordFields() {
        passwordTxt.setText("");
        confPasswordTxt.setText("");
    }

    private void showError(String msg) {
        msgLbl.setText(msg);
    }
}
