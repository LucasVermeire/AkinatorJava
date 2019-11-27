package views.Admin;

import controllers.IMainController;
import controllers.MainController;
import javafx.fxml.Initializable;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminFXMLController implements Initializable {

    private IMainController controller;

    public AdminFXMLController(MainController controller) {
        this.controller = controller;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
