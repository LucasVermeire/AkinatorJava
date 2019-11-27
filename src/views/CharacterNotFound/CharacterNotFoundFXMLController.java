package views.CharacterNotFound;

import controllers.IMainController;
import javafx.fxml.Initializable;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.util.ResourceBundle;

public class CharacterNotFoundFXMLController implements Initializable {

    private IMainController controller;

    public CharacterNotFoundFXMLController(IMainController controller) {
        this.controller = controller;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
