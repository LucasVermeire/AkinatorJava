package views.MainMenu;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.util.ResourceBundle;
import controllers.IMainController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class MenuFXMLController implements Initializable, PropertyChangeListener {

    private IMainController controller;

    public MenuFXMLController(IMainController controller){
        this.controller = controller;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

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

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
