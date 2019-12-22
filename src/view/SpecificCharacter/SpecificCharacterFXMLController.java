package view.SpecificCharacter;

import controller.IMainController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class SpecificCharacterFXMLController {

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
            ex.getMessage();
        }
    }
}
