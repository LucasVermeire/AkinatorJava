package view.FXML;

import controllers.MainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLSwitchView implements Initializable {

    @FXML
    private Button button;

    @FXML
    private BorderPane borderPane;

    private MainController controller;

    public FXMLSwitchView() {

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    protected void switchView(ActionEvent event) {
        button = (Button) event.getSource();
        String buttonId = button.getId();

        switch (buttonId) {
            case "startButton":
                loadView("view/FXML/theme.fxml");
                break;
            case "leaveButton":
                System.exit(0);
                break;
            case "adminButton":
                loadView("/view/FXML/Admin.fxml");
                break;
            case "modernCharacter":
                loadView("/view/FXML/Questions.fxml");
                break;
            case "menuButton":
                loadView("/view/FXML/MenuPrincipal.fxml");
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
