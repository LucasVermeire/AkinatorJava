package views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.HashMap;

public class SwitchView {

    private Stage stage;

    public SwitchView(Stage stage) {
        this.stage = stage;
    }

    public void loadView(String pathFXML, HashMap<String, Object> controllers) {
        Parent root;
        try {
            Object controller = controllers.get(pathFXML);
            FXMLLoader chargerFXML = new FXMLLoader (getClass().getResource("../views/" + pathFXML + "/" + pathFXML + ".fxml"));
            chargerFXML.setController(controller);
            root = chargerFXML.load();
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}