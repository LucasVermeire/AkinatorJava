package views.Question;

import controllers.IMainController;
import controllers.MainController;
import javafx.fxml.Initializable;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.util.ResourceBundle;

public class QuestionFXMLController implements Initializable , PropertyChangeListener {

    private IMainController controller;

    public QuestionFXMLController(MainController controller){
        this.controller = controller;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
