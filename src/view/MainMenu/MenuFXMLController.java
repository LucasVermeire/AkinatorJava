package view.MainMenu;

import controller.IMainController;
import javafx.fxml.FXML;

public class MenuFXMLController {

    private IMainController controller;

    public MenuFXMLController(IMainController controller){
        this.controller = controller;
    }

    @FXML
    private void start (){
        controller.switchView("Themes");
    }

    @FXML
    private void exit(){
        controller.exit();
    }

    @FXML
    private void admin(){
        controller.switchView("Admin");
    }
}
