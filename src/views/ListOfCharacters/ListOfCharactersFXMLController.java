package views.ListOfCharacters;

import controllers.IMainController;
import javafx.fxml.Initializable;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.util.ResourceBundle;

public class ListOfCharactersFXMLController implements Initializable, PropertyChangeListener {

    private IMainController controller;

    public ListOfCharactersFXMLController(IMainController controller) {
        this.controller = controller;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
