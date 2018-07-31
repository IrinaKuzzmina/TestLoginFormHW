package com.academy.fx.page;

import com.academy.fx.controller.LoginController;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginPage implements Page {
    private static final String STYLES = "styles/login.css";
    private Stage loginStage;
    private LoginController loginController;

    // view components
    private BorderPane bp;
    private HBox hb;
    private GridPane gridPane;
    private Label userNameLabel;
    private Label passwordLabel;
    private TextField userNameField;
    private PasswordField passwordField;
    private Button loginButton;
    private Label messageLabel;
    private Button registerButton;

    private Scene scene;

    public LoginPage(Stage loginStage) {
        this.loginStage = loginStage;
        this.loginController = new LoginController();
    }

    @Override
    public void show() {
        loginStage.show();
    }

    @Override
    public void close() {
        loginStage.close();
    }

    @Override
    public void init() {
        loginStage.setTitle("Login Form");

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
        userNameLabel = new Label("Username");
        userNameField = new TextField();
        passwordLabel = new Label("Password");
        passwordField = new PasswordField();
        loginButton = new Button("Login");
        messageLabel = new Label();
        registerButton = new Button("Register");

        //Adding Nodes to GridPane layout
        gridPane.add(userNameLabel, 0, 0);
        gridPane.add(userNameField, 1, 0);
        gridPane.add(passwordLabel, 0, 1);
        gridPane.add(passwordField, 1, 1);
        gridPane.add(loginButton, 2, 1);
        gridPane.add(messageLabel, 1, 2);
        gridPane.add(registerButton, 0, 3);

        //Reflection for gridPane
        Reflection r = new Reflection();
        r.setFraction(0.7f);
        gridPane.setEffect(r);

        //DropShadow effect
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(5);
        dropShadow.setOffsetY(5);

        //Adding text and DropShadow effect to it
        Text text = new Text("SignIn");
        text.setFont(Font.font("Courier New", FontWeight.BOLD, 28));
        text.setEffect(dropShadow);

        //Adding text to HBox
        hb.getChildren().add(text);

        //Add ID's to Nodes
        bp.setId("bp");
        gridPane.setId("root");
        loginButton.setId("btnLogin");
        text.setId("text");
        registerButton.setId("btnRegister");

        loginButton.setOnAction(loginController.onClickLoginButton(userNameField, passwordField, messageLabel));
        registerButton.setOnMouseClicked(loginController.onClickRegisterButton(this));

        //Add HBox and GridPane layout to BorderPane Layout
        bp.setTop(hb);
        bp.setCenter(gridPane);

        //Adding BorderPane to the scene and loading CSS
        scene = new Scene(bp);
        scene.getStylesheets().add(getClass().getClassLoader().getResource(STYLES).toExternalForm());
        loginStage.setScene(scene);

        loginStage.setScene(scene);
    }
}
