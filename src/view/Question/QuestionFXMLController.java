package view.Question;

import controller.IMainController;
import controller.MainController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class QuestionFXMLController implements Initializable , PropertyChangeListener {

    @FXML
    private Label label;

    private IMainController controller;

    public QuestionFXMLController(MainController controller){
        this.controller = controller;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        controller.notifyQuestion();
    }

    @FXML
    private void answerYes(){
        controller.answerYes();
    }

    @FXML
    private void answerNo(){
        controller.answerNo();
    }

    @FXML
    private void answerIDK(){
        controller.answerIDK();
    }

    @FXML
    private void questionOfSolution(){
        controller.switchView("QuestionOfSolution");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        label.setText(controller.getQuestion());
    }
}
