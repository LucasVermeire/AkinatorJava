package view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.util.ResourceBundle;
import controller.MainController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

import javax.swing.text.html.ImageView;

public class FXMLController implements Initializable, PropertyChangeListener {

    @FXML
    private Button startButton;

    @FXML
    private Button backButton;

    @FXML
    private ImageView imageView;

    private MainController controller;

    public FXMLController (MainController controller){
        this.controller = controller;
    }

    @FXML
    protected void chooseView(ActionEvent event){
        startButton = (Button) event.getSource();
        String buttonId = startButton.getId();
        controller.chooseView(buttonId);
    }

    @FXML
    protected void backView(ActionEvent event){
        backButton = (Button) event.getSource();
        String buttonId = backButton.getId();
        controller.backView(buttonId);
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
