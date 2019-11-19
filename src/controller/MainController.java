package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.FXMLController;
import javax.swing.text.html.ImageView;
import java.io.IOException;

public class MainController {

    private Stage stage;

    public MainController(Stage stage){
        this.stage = stage;
    }

    public void chooseView(String chooseView) {
        switch (chooseView){
            case "startButton":
                loadView("/view/FXML/theme.fxml","Choissisez votre thème !");
                break;
            case "leaveButton":
                System.exit(0);
                break;
            case "modernCharacter":
                loadView("/view/FXML/Question.fxml","Question");
                break;
            case "adminButton":
                loadView("/view/FXML/Admin.fxml","Paramètres Administrateur");
                break;
            default:
                break;
        }
    }

    public void backView(String chooseView){
        switch (chooseView){
            case "backButton":
            case "backAdmin":
                loadView("/view/FXML/MenuPrincipal.fxml","I'M JARVIS");
                break;
            case "backButtonTheme":
                loadView("/view/FXML/Theme.fxml","Choissisez votre thème !");
                break;
            default:
                break;
        }
    }

    private void loadView(String pathFXML,String title) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(pathFXML));
            MainController control = new MainController(stage);
            FXMLController FXMLControl = new FXMLController(control);
            fxmlLoader.setController(FXMLControl);
            Parent root = fxmlLoader.load();
            stage.setScene(new Scene(root));
            stage.setTitle(title);
            stage.show();
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
