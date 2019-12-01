package controllers;

import models.BankCharacters;
import models.Character;
import models.IKnowledge;
import models.Knowledge;
import views.*;
import views.AddCharacter.AddCharacterFXMLController;
import views.Admin.AdminFXMLController;
import views.CharacterFound.CharacterFoundFXMLController;
import views.CharacterNotFound.CharacterNotFoundFXMLController;
import views.CharacterIdea.CharacterIdeaFXMLController;
import views.ListOfCharacters.ListOfCharactersFXMLController;
import views.MainMenu.MenuFXMLController;
import views.Question.QuestionFXMLController;
import views.QuestionOfSolution.QuestionOfSolutionFXMLController;
import views.SpecificCharacter.SpecificCharacterFXMLController;
import views.Themes.ThemesFXMLController;
import java.util.HashMap;

/**
 * The MainController class is the main controller of my MVC architecture. It implements the IMainController interface.
 * @version 1.0
 * @author Lucas VERMEIRE
 */
public class MainController implements IMainController {

    //###############################
    private SwitchView view;
    private HashMap<String, Object> controllers;
    private IKnowledge knowledge = new Knowledge();
    //###############################

    /**
     * Builder of my class
     * It is composed of a HashMap which has a String as value and an object as key (controller view).
     * The SwitchView parameter allows me to retrieve the primaryStage
     * @param view SwitchView
     */
    public MainController(SwitchView view){
        controllers = new HashMap<>();
        controllers.put("MainMenu", new MenuFXMLController(this));
        controllers.put("Admin", new AdminFXMLController(this));
        controllers.put("AddCharacter", new AddCharacterFXMLController(this));
        controllers.put("Themes", new ThemesFXMLController(this));
        controllers.put("Question", new QuestionFXMLController(this));
        controllers.put("QuestionOfSolution", new QuestionOfSolutionFXMLController(this));
        controllers.put("ListOfCharacters", new ListOfCharactersFXMLController(this));
        controllers.put("CharacterIdea", new CharacterIdeaFXMLController(this));
        controllers.put("CharacterNotFound", new CharacterNotFoundFXMLController(this));
        controllers.put("CharacterFound", new CharacterFoundFXMLController(this));
        controllers.put("SpecificCharacter", new SpecificCharacterFXMLController(this));

        this.view = view;
    }

    //##########################################################

    @Override
    public String getQuestion(){
        return knowledge.getQuestion();
    }


    @Override
    public String getSolution(){
        return knowledge.characterFinalToString();
    }


    @Override
    public String getPathImg(){
        return "img/characters/"+knowledge.getPathImg();
    }

    //##########################################################

    /**
     * The void method SwitchView(String pathFXML) allows me to change the view according to its parameter
     * by calling a method the SwitchView class.
     *
     * If the parameter corresponds to the fxml Question file, it means that the knowledge bank must be restarted.
     *
     * @param fileFXML String
     */
    @Override
    public void switchView(String fileFXML){
        if(fileFXML.equals("Question")){
            resetBankOfKnowledge();
        }
        view.loadView(fileFXML,controllers);
    }

    private void resetBankOfKnowledge(){
        this.knowledge = new Knowledge();
        knowledge.addPropertyChangeListener((QuestionFXMLController) controllers.get("Question"));
    }

    @Override
    public void exit(){
        System.exit(0);
    }

    //##########################################################

    /**
     * The void method answerYes() uses the method of the same name from the Knowledge class
     * and the knowSolution() method from the MainController.
     */
    @Override
    public void answerYes(){
        knowledge.answerYes();
        knowSolution();
    }

    /**
     * The void method answerNo() uses the method of the same name from the Knowledge class
     * and the knowSolution() method from the MainController.
     */
    @Override
    public void answerNo(){
        knowledge.answerNo();
        knowSolution();
    }

    /**
     * The void method answerIDK() uses the method of the same name from the Knowledge class
     * and the knowSolution() method from the MainController.
     */
    @Override
    public void answerIDK(){
        knowledge.answerIDK();
        knowSolution();
    }

    /**
     * The private knowSolution method allows me to remove and add propertyChangeListener to the corresponding views and loads it.
     * It uses two private methods firstRemoveAndAddPropertyChangeListener(String,String) and
     * secondRemoveAndAddPropertyChangeListener(String,String)
     */
    private void knowSolution(){
        if(knowledge.knowCharacterFinal()){
            firstRemoveAndAddPropertyChangeListener("Question","QuestionOfSolution");
        }else if(knowledge.knowNumberOfQuestions() == knowledge.getIndex()){
            secondRemoveAndAddPropertyChangeListener("Question","ListOfCharacters");
        }else if(ifNoMoreCharacters()){
            switchView("CharacterIdea");
        }
    }

    private boolean ifNoMoreCharacters(){
        if(knowledge.getSetFinal().size()==0) return true;
        else return false;
    }

    private void firstRemoveAndAddPropertyChangeListener(String key1, String key2){
        knowledge.removePropertyChangeListener((QuestionFXMLController)controllers.get(key1));
        knowledge.addPropertyChangeListener((QuestionOfSolutionFXMLController)controllers.get(key2));
        switchView(key2);
    }

    private void secondRemoveAndAddPropertyChangeListener(String key1,String key2){
        knowledge.removePropertyChangeListener((QuestionFXMLController)controllers.get(key1));
        knowledge.addPropertyChangeListener((ListOfCharactersFXMLController)controllers.get(key2));
        switchView(key2);
    }

    //##########################################################

    @Override
    public void notifyQuestion() {
        knowledge.notifyQuestion();
    }

    @Override
    public void notifySolution(){
        knowledge.notifySolution();
    }

    //########################################################

    @Override
    public void addCharacter(String name){
        knowledge.addCharacter(name);
    }
}