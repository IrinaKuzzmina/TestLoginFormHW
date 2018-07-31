package com.academy.fx;

import com.academy.fx.page.LoginPage;
import com.academy.fx.page.Page;
import javafx.application.Application;
import javafx.stage.Stage;

public class AppMain extends Application {

    public static void main(String[] args) {
        System.out.println("Start Application");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Page loginPage = new LoginPage(primaryStage);
        loginPage.init();
        loginPage.show();
    }
}
