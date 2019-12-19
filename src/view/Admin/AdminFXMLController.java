package view.Admin;

import controller.IMainController;
import controller.MainController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 *
 */
public class AdminFXMLController implements Initializable {

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

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
            message.setText("Erreur de fichier !");
        }
    }

    @FXML
    private void importBank(){
        Window stage =  exportButton.getScene().getWindow();
        fileChooser.setTitle("Importer une banque de connnaissance");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("files","*.json"));

        try{
            File file = fileChooser.showOpenDialog(stage);
            fileChooser.setInitialDirectory(file.getParentFile());
            controller.importBank(file.getAbsolutePath());
            message.setText("Fichier importé avec succès !");
        }catch (Exception ignored){
            message.setText("Erreur de fichier !");
        }
    }
}
