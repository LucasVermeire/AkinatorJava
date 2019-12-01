package views.Admin;

import controllers.IMainController;
import controllers.MainController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

/**
 *
 */
public class AdminFXMLController implements Initializable {

    private IMainController controller;

    public AdminFXMLController(MainController controller) {
        this.controller = controller;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    private void addCharacter(){
        controller.switchView("AddCharacter");
    }

    @FXML
    private void mainMenu(){
        controller.switchView("MainMenu");
    }

}
