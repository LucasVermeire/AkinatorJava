package controllers;

import models.IKnowledge;
import models.Knowledge;
import views.*;
import views.MainMenu.MenuFXMLController;
import views.Question.QuestionFXMLController;
import views.QuestionOfSolution.QuestionOfSolutionFXMLController;
import views.Themes.ThemesFXMLController;
import java.util.HashMap;

public class MainController implements IMainController {

    private SwitchView view;
    private HashMap<String, Object> controllers;
    private IKnowledge knowledge;

    public MainController(SwitchView view){
        controllers = new HashMap<>();
        controllers.put("MainMenu", new MenuFXMLController(this));
        controllers.put("Themes", new ThemesFXMLController(this));
        controllers.put("Question", new QuestionFXMLController(this));
        controllers.put("QuestionOfSolution", new QuestionOfSolutionFXMLController(this));

        this.view = view;
    }

    @Override
    public void switchView(String fileFXML){
        if(fileFXML.equals("Question")){
            resetBankOfKnowledge();
        }
        view.loadView(fileFXML,controllers);
    }

    @Override
    public void answerYes(){
        knowledge.answerYes();
    }

    @Override
    public void answerNo(){
        knowledge.answerNo();
    }

    @Override
    public void answerIDK(){
        knowledge.answerIDK();
    }

    @Override
    public String getQuestion(){
        return knowledge.getQuestion();
    }

    @Override
    public void exit(){
        System.exit(0);
    }

    @Override
    public void notifyQuestion() {
        knowledge.notifyQuestion();
    }

    private void resetBankOfKnowledge(){
       this.knowledge = new Knowledge();
        knowledge.addPropertyChangeListener((QuestionFXMLController) controllers.get("Question"));
    }
}