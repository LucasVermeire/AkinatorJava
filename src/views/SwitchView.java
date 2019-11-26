package views;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class SwitchView implements Initializable {

    @FXML
    private Stage stage;

    public SwitchView(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void loadView(String pathFXML, HashMap<String, Object> controllers) {
        Parent root;
        try {
            Object controller = controllers.get(pathFXML);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../views/" + pathFXML + ".fxml"));
            loader.setController(controller);
            root = loader.load();
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
