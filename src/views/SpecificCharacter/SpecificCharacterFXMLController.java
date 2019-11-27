package views.SpecificCharacter;

import controllers.IMainController;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public class SpecificCharacterFXMLController implements Initializable {

    private IMainController controller;

    public SpecificCharacterFXMLController(IMainController controller) {
        this.controller = controller;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void validate(){

    }

    public void exit(){
        controller.exit();
    }

    public void mainMenu(){
        controller.switchView("MainMenu");
    }
}
