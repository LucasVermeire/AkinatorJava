package view.CharacterIdea;

import controller.MainController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CharacterIdeaFXMLController implements Initializable {

    private MainController controller;

    @FXML
    private TextField name;

    public CharacterIdeaFXMLController(MainController controller) {
        this.controller = controller;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void addCharacter (){
        controller.addCharacter(name.getText());
        controller.switchView("CharacterNotFound");
    }

    @FXML
    private void exit(){
        controller.exit();
    }
}
