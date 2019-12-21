package view.SpecificCharacter;

import controller.IMainController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ResourceBundle;

public class SpecificCharacterFXMLController implements Initializable {

    private IMainController controller;

    @FXML
    private TextField name;

    @FXML
    private Button chooseFile;

    @FXML
    private Label message;

    public SpecificCharacterFXMLController(IMainController controller)  {
        this.controller = controller;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void validate() {
        controller.addCharacter(name.getText());
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
        FileChooser fileChooser = new FileChooser();
        Window stage =  chooseFile.getScene().getWindow();
        fileChooser.setTitle("Choisir son image");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Images","*.jpg"));

        try{
            File file = fileChooser.showOpenDialog(stage);
            int dotIndex = file.getAbsolutePath().lastIndexOf(".");
            String ext = file.getAbsolutePath().substring(dotIndex);
            fileChooser.setInitialDirectory(file.getParentFile());
            File target = new File("src/img/characters/"+name.getText().replace(" ","_")+ ext);
            Files.copy(file.toPath(),target.toPath(), StandardCopyOption.REPLACE_EXISTING);
            message.setText("Fichier téléchargé !");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
