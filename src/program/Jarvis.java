package program;

import java.io.IOException;
import controllers.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import views.FXMLMenuController;

public class Jarvis extends Application {

    @Override
    public void start(Stage primaryStage){
        Parent root;
        try {
            FXMLLoader chargerFXML = new FXMLLoader (getClass().getResource("/views/MenuPrincipal.fxml"));
            MainController control = new MainController();
            FXMLMenuController FXMLControl = new FXMLMenuController(control);
            chargerFXML.setController(FXMLControl);
            root = chargerFXML.load();

            primaryStage.setTitle("I'M JARVIS");
            primaryStage.getIcons().add(new Image("/img/logo/Accueil.PNG"));
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
