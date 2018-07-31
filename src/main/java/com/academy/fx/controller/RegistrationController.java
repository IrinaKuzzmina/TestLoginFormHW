package com.academy.fx.controller;

import com.academy.fx.page.Page;
import com.academy.fx.page.RegistrationPage;
import com.academy.fx.validator.EmailValidator;
import com.academy.fx.validator.NameValidator;
import com.academy.fx.validator.PasswordValidator;
import com.academy.fx.validator.Validator;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class RegistrationController {
    private Validator nameValidator = new NameValidator();
    private Validator passwordValidator = new PasswordValidator();
    private Validator emailValidator = new EmailValidator();

    public EventHandler<? super MouseEvent> onClickRegisterButton(RegistrationPage registrationPage) {
        return event -> {
            System.out.println("Registration");
            String firstName =  registrationPage.getFirstName();
            String lastName = registrationPage.getLastName();
            String email = registrationPage.getMail();
            String password = registrationPage.getPassword();
            String confirmPassword =  registrationPage.getConfirmPassword();

            if (!nameValidator.validate(firstName)) {
                registrationPage.showError(nameValidator.getMsgError());
                return;
            }

            if (!nameValidator.validate(lastName)) {
                registrationPage.showError(nameValidator.getMsgError());
                return;
            }

            if (!emailValidator.validate(email)) {
                registrationPage.showError(emailValidator.getMsgError());
                return;
            }

            if (!passwordValidator.validate(password)){
                registrationPage.showError(passwordValidator.getMsgError());
                registrationPage.clearPasswordFields();
                return;
            }

            if (!password.equals(confirmPassword)) {
                registrationPage.showError("Not equals passwords");
                registrationPage.clearPasswordFields();
                return;
            }

            registrationPage.clearFields();
            registrationPage.showMessage("Congratulations!");
        };
    }
}
