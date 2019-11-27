package controllers;

import views.*;
import views.MainMenu.MenuFXMLController;
import views.Question.QuestionFXMLController;
import views.QuestionOfSolution.QuestionOfSolutionFXMLController;
import views.Themes.ThemesFXMLController;

import java.util.HashMap;

public class MainController implements IMainController {

    private SwitchView view;
    private HashMap<String, Object> controllers;

    public MainController(SwitchView view){
        controllers = new HashMap<>();
        controllers.put("MainMenu", new MenuFXMLController(this));
        controllers.put("Themes", new ThemesFXMLController(this));
        controllers.put("Question", new QuestionFXMLController(this));
        controllers.put("QuestionOfSolution", new QuestionOfSolutionFXMLController(this));

        this.view = view;
    }

    public void switchView(String fileFXML){
        view.loadView(fileFXML,controllers);
        if(fileFXML.equals("Question")){
            resetBankOfKnowledge();
        }
    }

    public void exit(){
        System.exit(0);
    }

    private void resetBankOfKnowledge(){
        /*IKnowledge knowledge = new Knowledge();
        knowledge.addPropertyChangeListener((PropertyChangeListener) controllers.get("Question"));
        System.out.println("OKOKOKOKO");*/
    }
}
