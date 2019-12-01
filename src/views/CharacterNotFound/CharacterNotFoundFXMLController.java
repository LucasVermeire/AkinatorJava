package views.CharacterNotFound;

import controllers.IMainController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public class CharacterNotFoundFXMLController implements Initializable {

    private IMainController controller;

    public CharacterNotFoundFXMLController(IMainController controller) {
        this.controller = controller;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

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
