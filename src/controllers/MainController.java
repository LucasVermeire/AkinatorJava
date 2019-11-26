package controllers;

import models.Knowledge;
import views.*;
import views.MenuPrincipal.MenuFXMLController;
import views.Question.QuestionFXMLController;
import views.Themes.ThemeFXMLController;

import java.util.HashMap;

public class MainController implements IMainController {

    private SwitchView view;
    private Knowledge knowledge;
    private HashMap<String, Object> controllers;

    public MainController(SwitchView view){
        controllers = new HashMap<>();
        controllers.put("MenuPrincipal", new MenuFXMLController(this));
        controllers.put("Themes", new ThemeFXMLController(this));
        controllers.put("Question", new QuestionFXMLController(this));

        this.view = view;
    }

    public void switchView(String fileFXML){
        view.loadView(fileFXML,controllers);
    }

    public void exit(){
        System.exit(0);
    }
}
