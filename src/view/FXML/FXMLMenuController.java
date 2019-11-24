package view.FXML;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.util.ResourceBundle;

import controllers.MainController;
import javafx.fxml.Initializable;

public class FXMLMenuController extends FXMLSwitchView implements Initializable, PropertyChangeListener {

    private MainController controller;

    public FXMLMenuController(MainController controller){
        super();
        this.controller = controller;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
