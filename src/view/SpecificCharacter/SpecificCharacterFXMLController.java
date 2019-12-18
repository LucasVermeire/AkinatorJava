package view.SpecificCharacter;

import controller.IMainController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SpecificCharacterFXMLController implements Initializable {

    private IMainController controller;

    @FXML
    private TextField name;

    @FXML
    private TextField img;

    public SpecificCharacterFXMLController(IMainController controller) {
        this.controller = controller;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void validate(){
        controller.addCharacter(name.getText(), img.getText());
        controller.switchView("CharacterNotFound");
    }

    @FXML
    private void exit(){
        controller.exit();
    }

    @FXML
    private void mainMenu(){
        controller.switchView("MainMenu");
    }
}
