package com.academy.fx.controller;

import com.academy.fx.model.User;
import com.academy.fx.page.PageFactory;
import com.academy.fx.service.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.List;

public class AdminController {

    @FXML
    private GridPane grid;

    private UserService userService = UserService.getInstance();

    public void onInit() {
        System.out.println("grid: " + grid);
        List<User> users = userService.getAll();
        for (int i = 0; i < users.size(); i++) {
            System.out.println("user: " + users.get(i));
            Label firstNameLbl = new Label();
            Label lastNameLbl = new Label();
            Label mailLbl = new Label();

            firstNameLbl.setText(users.get(i).getFirstName());
            lastNameLbl.setText(users.get(i).getLastName());
            mailLbl.setText(users.get(i).getMail());

            grid.add(firstNameLbl, 0, i+1);
            grid.add(lastNameLbl, 1, i+1);
            grid.add(mailLbl, 2, i+1);
        }
    }

    @FXML
    public void onClickLoginLink() {
        PageFactory.getAdminPage().hide();
        PageFactory.getLoginPage().show();
    }

    @FXML
    public void onClickRegisterLink() {
        PageFactory.getAdminPage().hide();
        PageFactory.getRegistrationPage().show();
    }

    public void onHide() {
        grid.getRowConstraints().remove(1, grid.getRowConstraints().size()+1);
    }
}
