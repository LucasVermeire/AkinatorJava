package views.AddCharacter;

import controllers.MainController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AddCharacterFXMLController implements Initializable {

    @FXML
    private TextField text;

    private MainController controller;

    public AddCharacterFXMLController( MainController controller) {
        this.controller = controller;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void validateAddition(){
        controller.addCharacter(text.getText());
        controller.switchView("MainMenu");
    }

    @FXML
    private void exit(){
        controller.exit();
    }
}
