package views.CharacterIdea;

import controllers.MainController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public class CharacterIdeaFXMLController implements Initializable {

    private MainController controller;

    public CharacterIdeaFXMLController(MainController controller) {
        this.controller = controller;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void validate (){
        controller.switchView("CharacterNotFound");
    }

    @FXML
    private void exit(){
        controller.exit();
    }
}