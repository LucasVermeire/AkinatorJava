package views.MainMenu;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.util.ResourceBundle;

import controllers.IMainController;
import javafx.fxml.Initializable;

public class MenuFXMLController implements Initializable, PropertyChangeListener {

    private IMainController controller;


    public MenuFXMLController(IMainController controller){
        this.controller = controller;
    }

    public void start (){
        controller.switchView("Themes");
    }

    public void exit(){
        controller.exit();
    }

    public void admin(){
        controller.switchView("Admin");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
