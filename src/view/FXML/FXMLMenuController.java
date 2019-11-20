package view.FXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import controllers.MainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;


public class FXMLMenuController implements Initializable {

    @FXML
    private Button startButton;

    @FXML
    private Button leaveButton;

    @FXML
    private Button adminButton;

    @FXML
    private BorderPane borderPane;

    private MainController controller;

    public FXMLMenuController(MainController controller){
        this.controller = controller;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    protected void switchView(ActionEvent event) {
        startButton = (Button) event.getSource();
        String buttonId = startButton.getId();

        switch (buttonId) {
            case "startButton":
                loadView("/view/FXML/theme.fxml");
                break;
            case "leaveButton":
                System.exit(0);
                break;
            case "adminButton":
                loadView("/view/FXML/Admin.fxml");
                break;
            default:
                break;
        }
    }

    private void loadView(String pathFXML) {
        Parent root ;
        try{
            root = FXMLLoader.load(getClass().getResource(pathFXML));
            borderPane.getScene().setRoot(root);

        }catch(IOException ex){
            System.err.println(ex.getMessage());
        }
    }
}
