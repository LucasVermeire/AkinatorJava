package views.ListOfCharacters;

import controllers.IMainController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Pagination;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.util.ResourceBundle;

public class ListOfCharactersFXMLController implements Initializable, PropertyChangeListener {

    private IMainController controller;

    @FXML
    private Pagination pagination;

    @FXML
    private ComboBox<String> listCharacters;


    public ListOfCharactersFXMLController(IMainController controller) {
        this.controller = controller;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       controller.notifySolution();
    }

    public void addCharacter(){
        controller.addCharacter(listCharacters.getSelectionModel().getSelectedItem());
        controller.switchView("CharacterNotFound");
    }

    @FXML
    private void characterIsNotInTheList(){
        controller.switchView("SpecificCharacter");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String [] names = controller.getListCharacters();
        ObservableList<String> values = FXCollections.observableArrayList();
        values.addAll(names);
        listCharacters.setItems(values);
        listCharacters.setValue(names[0]);
    }
}
