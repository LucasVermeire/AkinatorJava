package view.Admin;

import controller.IMainController;
import controller.MainController;
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
    private void mainMenu(){
        controller.switchView("MainMenu");
    }

    @FXML
    private void export(){
        controller.exportFile();
    }
}
