package views.Question;

import controllers.IMainController;
import controllers.MainController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import models.IKnowledge;
import models.Knowledge;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.util.ResourceBundle;

public class QuestionFXMLController implements Initializable , PropertyChangeListener {

    @FXML
    private Label label;

    private Knowledge knowledge;
    private IMainController controller;

    public QuestionFXMLController(MainController controller){
        this.controller = controller;
        knowledge = new Knowledge();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        label.setText(knowledge.getQuestion());
    }
}
