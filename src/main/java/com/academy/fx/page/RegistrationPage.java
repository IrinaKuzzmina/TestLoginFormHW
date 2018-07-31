package com.academy.fx.page;

import com.academy.fx.controller.RegistrationController;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RegistrationPage implements Page {
    private static final String STYLES = "styles/register.css";

    private Stage registrationStage;
    private RegistrationController registrationController;

    // view components
    private BorderPane bp;
    private HBox hb;
    private GridPane gridPane;
    private Label firstNameLabel;
    private Label lastNameLabel;
    private Label mailLabel;
    private Label passwordLabel;
    private Label confirmPasswordLabel;
    private TextField firstNameField;
    private TextField lastNameField;
    private TextField mailField;
    private PasswordField passwordField;
    private PasswordField confirmPasswordField;
    private Label messageLabel;
    private Button createButton;

    private Scene scene;

    public RegistrationPage() {
        registrationController = new RegistrationController();
    }

    public Label getFirstNameLabel() {
        return firstNameLabel;
    }

    public Label getLastNameLabel() {
        return lastNameLabel;
    }

    public Label getMailLabel() {
        return mailLabel;
    }

    public Label getPasswordLabel() {
        return passwordLabel;
    }

    public Label getConfirmPasswordLabel() {
        return confirmPasswordLabel;
    }

    public TextField getFirstNameField() {
        return firstNameField;
    }

    public TextField getLastNameField() {
        return lastNameField;
    }

    public TextField getMailField() {
        return mailField;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public PasswordField getConfirmPasswordField() {
        return confirmPasswordField;
    }

    public Label getMessageLabel() {
        return messageLabel;
    }



    @Override
    public void init() {
        StackPane secondaryLayout = new StackPane();
        scene = new Scene(secondaryLayout, 200, 100);
        registrationStage = new Stage();
        registrationStage.setTitle("Registration Page");
        registrationStage.setScene(scene);

        registrationStage.setTitle("Login Form");

        bp = new BorderPane();
        bp.setPadding(new Insets(10,50,50,50));

        //Adding HBox
        hb = new HBox();
        hb.setPadding(new Insets(20,20,20,30));

        //Adding GridPane
        gridPane = new GridPane();
        gridPane.setPadding(new Insets(20,20,20,20));
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        //Implementing Nodes for GridPane
        firstNameLabel = new Label("First Name");
        firstNameField = new TextField();
        lastNameLabel = new Label("Last Name");
        lastNameField = new TextField();
        mailLabel = new Label("Email");
        mailField = new TextField();
        passwordLabel = new Label("Password");
        passwordField = new PasswordField();
        confirmPasswordLabel = new Label("Confirm Password");
        confirmPasswordField = new PasswordField();
        createButton = new Button("Create");
        messageLabel = new Label();

        //Adding Nodes to GridPane layout
        gridPane.add(firstNameLabel, 0, 0);
        gridPane.add(firstNameField, 1, 0);
        gridPane.add(lastNameLabel, 0, 1);
        gridPane.add(lastNameField, 1, 1);
        gridPane.add(mailLabel, 0, 2);
        gridPane.add(mailField, 1, 2);
        gridPane.add(passwordLabel, 0, 3);
        gridPane.add(passwordField, 1, 3);
        gridPane.add(confirmPasswordLabel, 0, 4);
        gridPane.add(confirmPasswordField, 1, 4);
        gridPane.add(createButton, 0, 5);
        gridPane.add(messageLabel, 0, 6);

        //Reflection for gridPane
        Reflection r = new Reflection();
        r.setFraction(0.7f);
        gridPane.setEffect(r);

        //DropShadow effect
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(5);
        dropShadow.setOffsetY(5);

        //Adding text and DropShadow effect to it
        Text text = new Text("Registration");
        text.setFont(Font.font("Courier New", FontWeight.BOLD, 28));
        text.setEffect(dropShadow);

        //Adding text to HBox
        hb.getChildren().add(text);

        //Add ID's to Nodes
        bp.setId("bp");
        gridPane.setId("root");
        text.setId("text");
        createButton.setId("btnRegister");

        createButton.setOnMouseClicked(registrationController.onClickRegisterButton(this));

        //Add HBox and GridPane layout to BorderPane Layout
        bp.setTop(hb);
        bp.setCenter(gridPane);

        //Adding BorderPane to the scene and loading CSS
        scene = new Scene(bp);
        scene.getStylesheets().add(getClass().getClassLoader().getResource(STYLES).toExternalForm());
        registrationStage.setScene(scene);

        registrationStage.setScene(scene);
    }

    @Override
    public void show() {
        registrationStage.show();
    }

    @Override
    public void close() {
        registrationStage.close();
    }

    public void clearFields() {
        firstNameField.setText("");
        lastNameField.setText("");
        mailField.setText("");
        passwordField.setText("");
        confirmPasswordField.setText("");
    }

    public void clearPasswordFields() {
        passwordField.setText("");
        confirmPasswordField.setText("");
    }

    public void showError(String msg) {
        messageLabel.setText(msg);
        messageLabel.setTextFill(Color.RED);
    }

    public void showMessage(String msg) {
        messageLabel.setText(msg);
        messageLabel.setTextFill(Color.GREEN);
    }
}
