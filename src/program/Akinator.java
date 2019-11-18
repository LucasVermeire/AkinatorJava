package program;

import java.io.IOException;

import controler.MainControler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Akinator extends Application {

    @Override
    public void start(Stage primaryStage){
        Parent root;
        try {
            FXMLLoader chargeurFXML = new FXMLLoader (getClass().getResource("/view/MenuPrincipal.fxml"));
            chargeurFXML.setController(new MainControler());
            root = chargeurFXML.load();

            primaryStage.setTitle("I'M JARVIS");
            Scene scene = new Scene(root,719,619);
            primaryStage.setScene(scene);
            primaryStage.show();

        }catch(IOException ex) {
            System.err.println(ex.getStackTrace());
        }
    }

    public static void main(String[]args) {
        launch(args);
    }
}
