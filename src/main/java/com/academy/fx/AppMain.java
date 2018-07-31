package com.academy.fx;

import com.academy.fx.page.Page;
import com.academy.fx.page.RegistrationPage;
import javafx.application.Application;
import javafx.stage.Stage;

public class AppMain extends Application {

    public static void main(String[] args) {
        System.out.println("Start Application");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Page registrationPage = new RegistrationPage();
        registrationPage.init();
        registrationPage.show();
    }
}
