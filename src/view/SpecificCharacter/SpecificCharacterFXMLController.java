package view.SpecificCharacter;

import controller.IMainController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class SpecificCharacterFXMLController implements Initializable {

    private IMainController controller;

    @FXML
    private TextField name;

    @FXML
    private Button chooseFile;

    @FXML
    private Label message;

    private String pathImg;

    private FileChooser fileChooser = new FileChooser();


    public SpecificCharacterFXMLController(IMainController controller) {
        this.controller = controller;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void validate(){
        controller.addCharacter(name.getText(), pathImg);
        controller.switchView("CharacterNotFound");
    }

    @FXML
    private void exit(){
        controller.exit();
    }

    @FXML
    private void mainMenu(){
        controller.switchView("MainMenu");
    }

    @FXML
    private void chooseFile(){
        Window stage =  chooseFile.getScene().getWindow();
        fileChooser.setTitle("Choisir son image");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Images","*.jpg","*.png"));

        try{
            File file = fileChooser.showOpenDialog(stage);
            fileChooser.setInitialDirectory(file.getParentFile());
            pathImg = file.getAbsolutePath();
            Path sourceDirectory = Paths.get(pathImg);
            Path targetDirectory = Paths.get("C:\\B2-info\\IntelliJ_Lucas_VERMEIRE_Akinator\\src\\img\\characters\\"+pathImg.substring((pathImg.lastIndexOf("\\"))));
            Files.copy(sourceDirectory,targetDirectory);
            Files.delete(targetDirectory);
        }catch (Exception ex){
            message.setText("Erreur d'image !");
        }
    }
}
