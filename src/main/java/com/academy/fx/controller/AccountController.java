package com.academy.fx.controller;

import com.academy.fx.model.User;
import com.academy.fx.page.PageFactory;
import com.academy.fx.service.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;

public class AccountController  {
    private String email;

    // view components
    @FXML
    private Label firstNameLbl;
    @FXML
    private Label lastNameLbl;
    @FXML
    private Label emailLbl;

    @FXML
    private Hyperlink firstNameHl;
    @FXML
    private Hyperlink lastNameHl;
    @FXML
    private Hyperlink emailHl;

    private UserService userService = UserService.getInstance();

    public void init(String email) {
        this.email = email;

        User user = userService.getByEmail(email);

        firstNameHl.setText(user.getFirstName());
        lastNameHl.setText(user.getLastName());
        emailHl.setText(user.getMail());
    }

    public void onClickRegisterLink() {
        PageFactory.getAccountPage(email).hide();
        PageFactory.getRegistrationPage().show();
    }
}
