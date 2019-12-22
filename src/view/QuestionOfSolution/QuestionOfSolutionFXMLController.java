package view.QuestionOfSolution;

import controller.IMainController;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
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

    @FXML
    private void characterFound(){
        controller.switchView("CharacterFound");
    }

    @FXML
    private void specificCharacter(){
        controller.switchView("SpecificCharacter");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        label.setText(controller.getSolution());

        File fileImage = new File("." + File.separator + controller.getPathImg());

        try {
            BufferedImage in = ImageIO.read(fileImage);

            Image image = SwingFXUtils.toFXImage(in, null);

            imgCharacter.setImage(image);

        } catch (IOException e) {
            e.getMessage();
        }
    }
}