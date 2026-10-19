package main.ejercicio3_2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("primary.fxml"));
        stage.setTitle("Fábulas gráficas de Esopo");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }
}