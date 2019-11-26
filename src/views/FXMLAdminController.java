package views;

import controllers.IMainController;
import controllers.MainController;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLAdminController implements Initializable {

    private IMainController controller;

    public FXMLAdminController(MainController controller) {
        this.controller = controller;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
