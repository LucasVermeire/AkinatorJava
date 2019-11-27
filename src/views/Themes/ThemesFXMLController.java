package views.Themes;

import controllers.IMainController;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public class ThemesFXMLController implements Initializable  {

    private IMainController controller;

    public ThemesFXMLController(IMainController controller){
        this.controller = controller;
    }

    public void chooseCharacter(){
        controller.switchView("Question");
    }

    public void backToMenu(){
        controller.switchView("MainMenu");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
