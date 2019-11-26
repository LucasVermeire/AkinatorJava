package views;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.util.ResourceBundle;

import controllers.IMainController;
import controllers.MainController;
import javafx.fxml.Initializable;

public class FXMLMenuController extends FXMLSwitchView implements Initializable, PropertyChangeListener {

    private IMainController controller;

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
