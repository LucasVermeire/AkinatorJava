package views.Question;

import controllers.IMainController;
import controllers.MainController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.util.ResourceBundle;

public class QuestionFXMLController implements Initializable , PropertyChangeListener {

    @FXML
    private Label label;

    private IMainController controller;

    public QuestionFXMLController(MainController controller){
        this.controller = controller;
    }

    public void questionOfSolution(){
        controller.switchView("QuestionOfSolution");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        controller.notifyQuestion();
    }

    public void answerYes(){
        controller.answerYes();
    }

    public void answerNo(){
        controller.answerNo();
    }

    public void answerIDK(){
        controller.answerIDK();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        label.setText(controller.getQuestion());
    }
}
