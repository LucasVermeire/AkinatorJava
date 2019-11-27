package views.CharacterFound;

import controllers.IMainController;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public class CharacterFoundFXMLController implements Initializable {

    private IMainController controller;

    public CharacterFoundFXMLController(IMainController controller) {
        this.controller = controller;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void restart(){
        controller.switchView("Question");
    }

    public void exit(){
        controller.exit();
    }

    public void mainMenu(){
        controller.switchView("MainMenu");
    }
}
