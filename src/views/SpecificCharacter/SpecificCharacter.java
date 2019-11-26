package views.SpecificCharacter;

import controllers.IMainController;
import javafx.fxml.Initializable;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.util.ResourceBundle;

public class SpecificCharacter implements Initializable, PropertyChangeListener {

    private IMainController controller;

    public SpecificCharacter(IMainController controller) {
        this.controller = controller;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
