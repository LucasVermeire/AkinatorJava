package view.Admin;

import controller.IMainController;
import controller.MainController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class AdminFXMLController {

    private IMainController controller;

    @FXML
    private Button exportButton;

    @FXML
    private Button importButton;

    @FXML
    private Label message;

    private FileChooser fileChooser = new FileChooser();

    public AdminFXMLController(MainController controller) {
        this.controller = controller;
    }

    @FXML
    private void mainMenu(){
        controller.switchView("MainMenu");
    }

    @FXML
    private void exportBank(){
        Window stage =  exportButton.getScene().getWindow();
        fileChooser.setTitle("Enregistrer la banque de connnaissance");
        fileChooser.setInitialFileName("bank.json");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("files","*.json"));

        try{
            File file = fileChooser.showSaveDialog(stage);
            fileChooser.setInitialDirectory(file.getParentFile());
            controller.exportBank(file.getAbsolutePath());
            message.setText("Fichier sauvegardé avec succès !");
        }catch (Exception ignored){
            message.setText("Exportation échouée !");
        }
    }

    @FXML
    private void importBank(){
        Window stage =  importButton.getScene().getWindow();
        fileChooser.setTitle("Importer une banque de connnaissance");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("files","*.json"));

        try{
            File file = fileChooser.showOpenDialog(stage);
            fileChooser.setInitialDirectory(file.getParentFile());
            int dotIndex = file.getAbsolutePath().lastIndexOf("\\");
            String name = file.getAbsolutePath().substring(dotIndex);
            File target = new File("rsc/"+name);
            Files.copy(file.toPath(),target.toPath(), StandardCopyOption.REPLACE_EXISTING);
            controller.importBank(target.getPath());
            message.setText("Fichier importé avec succès !");
        }catch (Exception ignored){
            message.setText("Importation échouée !");
        }
    }
}
