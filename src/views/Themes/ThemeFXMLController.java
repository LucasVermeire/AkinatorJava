package views.Themes;

import controllers.IMainController;
import javafx.fxml.Initializable;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.util.ResourceBundle;

public class ThemeFXMLController implements Initializable , PropertyChangeListener {

    private IMainController controller;

    public ThemeFXMLController(IMainController controller){
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
