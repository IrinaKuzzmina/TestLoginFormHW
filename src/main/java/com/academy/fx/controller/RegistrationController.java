package com.academy.fx.controller;

import com.academy.fx.page.Page;
import com.academy.fx.page.RegistrationPage;
import com.academy.fx.validator.PasswordValidator;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class RegistrationController {
    private PasswordValidator passwordValidator = new PasswordValidator();

    public EventHandler<? super MouseEvent> onClickRegisterButton(RegistrationPage registrationPage) {
        return event -> {
            System.out.println("Registration");
           String firstName =  registrationPage.getFirstNameField().getText();
           String lastName = registrationPage.getLastNameField().getText();
           String email = registrationPage.getMailField().getText();
           String password = registrationPage.getPasswordField().getText();
           String confirmPassword =  registrationPage.getConfirmPasswordField().getText();

//           if (!firstName.isEmpty())
           if (passwordValidator.validate(password)){
               if (password.equals(confirmPassword)) {
                   registrationPage.getMessageLabel().setText("Congratulations!");
               }
           } else {
               registrationPage.clearFields();
               registrationPage.getMessageLabel().setText(passwordValidator.getMsgError());
           }
//            checkUser = userNameField.getText();
//            checkPw = passwordField.getText();
//            if (checkUser.equals(user) && checkPw.equals(pw)) {
//                msgLabel.setText("Congratulations!");
//                msgLabel.setTextFill(Color.GREEN);
//            } else {
//                msgLabel.setText("Incorrect user or pw.");
//                msgLabel.setTextFill(Color.RED);
//            }
//            userNameField.setText("");
//            passwordField.setText("");
        };
    }
}
