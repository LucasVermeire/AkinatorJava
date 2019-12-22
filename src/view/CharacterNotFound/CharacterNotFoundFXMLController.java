package view.CharacterNotFound;

import controller.IMainController;
import javafx.fxml.FXML;

public class CharacterNotFoundFXMLController  {

    private IMainController controller;

    public CharacterNotFoundFXMLController(IMainController controller) {
        this.controller = controller;
    }

    @FXML
    private void restart(){
        controller.restart();
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
