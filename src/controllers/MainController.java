package controllers;

import models.Knowledge;
import views.*;
import java.util.HashMap;

public class MainController implements IMainController {

    private SwitchView view;
    private Knowledge knowledge;
    private HashMap<String, Object> controllers;

    public MainController(SwitchView view){
        controllers = new HashMap<>();
        controllers.put("MenuPrincipal", new FXMLMenuController(this));
        controllers.put("Themes", new FXMLThemeController(this));
        controllers.put("Question", new FXMLQuestionController(this));

        this.view = view;
    }

    public void switchView(String fileFXML){
        view.loadView(fileFXML,controllers);
    }

    public void exit(){
        System.exit(0);
    }
}
