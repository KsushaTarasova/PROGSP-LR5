package org.example.lr5_2;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 581, 557);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.setOnCloseRequest(windowEvent -> System.out.println("Окно закрыто"));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
