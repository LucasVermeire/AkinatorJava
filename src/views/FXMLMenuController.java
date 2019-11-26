package views;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import controllers.IMainController;
import controllers.MainController;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import models.Knowledge;

public class FXMLMenuController implements Initializable, PropertyChangeListener {

    private IMainController controller;


    public FXMLMenuController(IMainController controller){
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
