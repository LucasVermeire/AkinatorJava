package views.CharacterFound;

import controllers.IMainController;
import javafx.fxml.Initializable;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.util.ResourceBundle;

public class CharacterFoundFXMLController implements Initializable, PropertyChangeListener {

    private IMainController controller;

    public CharacterFoundFXMLController(IMainController controller) {
        this.controller = controller;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
