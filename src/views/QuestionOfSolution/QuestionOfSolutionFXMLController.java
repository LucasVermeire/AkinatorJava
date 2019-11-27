package views.QuestionOfSolution;

import controllers.IMainController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import models.IKnowledge;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.util.ResourceBundle;

public class QuestionOfSolutionFXMLController implements Initializable, PropertyChangeListener {

    @FXML
    private Label label;

    @FXML
    private ImageView imgCharacter;


    private IMainController controller;

    public QuestionOfSolutionFXMLController(IMainController controller) {
        this.controller = controller;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        controller.notifySolution();
    }

    public void characterFound(){
        controller.switchView("CharacterFound");
    }

    public void characterNotFound(){
        controller.switchView("CharacterNotFound");
    }

    public void continueQuestion(){
        controller.switchView("Question");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        label.setText(controller.getSolution());
        imgCharacter.setImage(new Image(controller.getPathImg()));
    }
}
