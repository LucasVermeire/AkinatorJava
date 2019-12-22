package view.CharacterFound;

import controller.IMainController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public class CharacterFoundFXMLController {

    private IMainController controller;

    public CharacterFoundFXMLController(IMainController controller) {
        this.controller = controller;
    }

    @FXML
    private void restart(){
        controller.switchView("Question");
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
