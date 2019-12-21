package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
            FXMLLoader chargerFXML = new FXMLLoader (getClass().getResource("../view/" + pathFXML + "/" + pathFXML + ".fxml"));
            chargerFXML.setController(controller);
            root = chargerFXML.load();
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}