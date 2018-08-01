package com.academy.fx;

import com.academy.fx.page.PageFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class AppMain extends Application {

    public static void main(String[] args) {
        System.out.println("Start Application");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        PageFactory.getLoginPage(primaryStage).show();
    }
}
