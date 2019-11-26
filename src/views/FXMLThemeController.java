package views;

import controllers.IMainController;
import javafx.fxml.Initializable;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLThemeController implements Initializable , PropertyChangeListener {

    private IMainController controller;

    public FXMLThemeController(IMainController controller){
        this.controller = controller;
    }

    public void chooseCharacter(){
        controller.switchView("Question");
    }

    public void backToMenu(){
        controller.switchView("MenuPrincipal");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
