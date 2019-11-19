package program;

import java.io.IOException;

import controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.FXMLController;

public class Jarvis extends Application {

    @Override
    public void start(Stage primaryStage){
        Parent root;
        try {
            FXMLLoader chargerFXML = new FXMLLoader (getClass().getResource("/view/FXML/MenuPrincipal.fxml"));
            MainController control = new MainController(primaryStage);
            FXMLController FXMLControl = new FXMLController(control);
            chargerFXML.setController(FXMLControl);
            root = chargerFXML.load();

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
