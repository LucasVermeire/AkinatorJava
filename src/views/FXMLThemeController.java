package views;

import controllers.IMainController;
import controllers.MainController;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLThemeController extends FXMLSwitchView implements Initializable {

    private IMainController controller;

    public FXMLThemeController(MainController controller){
        super();
        this.controller = controller;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
