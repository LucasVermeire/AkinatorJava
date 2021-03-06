package controller;

import model.*;
import view.*;
import view.Admin.AdminFXMLController;
import view.CharacterFound.CharacterFoundFXMLController;
import view.CharacterNotFound.CharacterNotFoundFXMLController;
import view.ListOfCharacters.ListOfCharactersFXMLController;
import view.MainMenu.MenuFXMLController;
import view.Question.QuestionFXMLController;
import view.QuestionOfSolution.QuestionOfSolutionFXMLController;
import view.SpecificCharacter.SpecificCharacterFXMLController;
import view.Themes.ThemesFXMLController;
import java.io.File;
import java.util.*;

/**
 * The MainController class is the main controller of my MVC architecture. It implements the IMainController interface.
 * @version 1.0
 * @author Lucas VERMEIRE
 */
public class MainController implements IMainController {

    private SwitchView view;
    private HashMap<String, Object> controllers;
    private IKnowledge knowledge;

    /**
     * Builder of my class
     * It is composed of a HashMap which has a String as value and an object as key (controller view).
     * The SwitchView parameter allows me to retrieve the primaryStage
     * @param view SwitchView
     */
    public MainController(SwitchView view){
        controllers = new HashMap<>();
        controllers.put(ViewEnum.MainMenu.name(), new MenuFXMLController(this));
        controllers.put(ViewEnum.Admin.name(), new AdminFXMLController(this));
        controllers.put(ViewEnum.Themes.name(), new ThemesFXMLController(this));
        controllers.put(ViewEnum.Question.name(), new QuestionFXMLController(this));
        controllers.put(ViewEnum.QuestionOfSolution.name(), new QuestionOfSolutionFXMLController(this));
        controllers.put(ViewEnum.ListOfCharacters.name(), new ListOfCharactersFXMLController(this));
        controllers.put(ViewEnum.CharacterNotFound.name(), new CharacterNotFoundFXMLController(this));
        controllers.put(ViewEnum.CharacterFound.name(), new CharacterFoundFXMLController(this));
        controllers.put(ViewEnum.SpecificCharacter.name(), new SpecificCharacterFXMLController(this));

        this.view = view;
        this.knowledge = new Knowledge();
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
        return "src" + File.separator + "img" + File.separator + "characters" + File.separator + knowledge.getImgLastCharacter();
    }

    @Override
    public BankCharacters getCharacters(){
        return knowledge.getBankCharacter();
    }

    @Override
    public String[] getListCharacters(){
        BankCharacters bank = getCharacters();
        int length = bank.getBankCharacters().size();
        String [] arrayFinalCharacters = new String[length];
        int i = 0;

        for(ICharacter item : bank.getBankCharacters()){
            if(!item.equals(knowledge.getLastCharacter())){
                arrayFinalCharacters[i] = item.getName();
            }
            i++;
        }
        return arrayFinalCharacters;
    }

    /**
     * The void method SwitchView(String pathFXML) allows me to change the view according to its parameter
     * by calling a method the SwitchView class. If the parameter corresponds to the fxml Question file,
     * it means that the knowledge bank must be restarted.
     *
     * @param fileFXML String
     */
    @Override
    public void switchView(String fileFXML){
        view.loadView(fileFXML,controllers);
        if(fileFXML.equals("Question")){
            restart();
        }
    }

    @Override
    public void restart(){
        knowledge.restart();
        knowledge.addPropertyChangeListener((QuestionFXMLController) controllers.get("Question"));
        notifyQuestion();
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
            firstRemoveAndAddPropertyChangeListener();
        }else if(knowledge.knowNumberOfQuestions() == knowledge.getIndex() && knowledge.getSetFinal().size()>0){
            secondRemoveAndAddPropertyChangeListener();
        }else if(ifNoMoreCharacters()){
            switchView("SpecificCharacter");
        }
    }

    private boolean ifNoMoreCharacters(){
        return knowledge.getSetFinal().size() == 0;
    }

    private void firstRemoveAndAddPropertyChangeListener(){
        knowledge.removePropertyChangeListener((QuestionFXMLController)controllers.get("Question"));
        knowledge.addPropertyChangeListener((QuestionOfSolutionFXMLController)controllers.get("QuestionOfSolution"));
        switchView("QuestionOfSolution");
    }

    private void secondRemoveAndAddPropertyChangeListener(){
        knowledge.removePropertyChangeListener((QuestionFXMLController)controllers.get("Question"));
        knowledge.addPropertyChangeListener((ListOfCharactersFXMLController)controllers.get("ListOfCharacters"));
        switchView("ListOfCharacters");
    }

    @Override
    public void notifyQuestion() {
        knowledge.notifyQuestion();
    }

    @Override
    public void notifySolution(){
        knowledge.notifySolution();
    }


   @Override
    public void addCharacter(String name){
       knowledge.addCharacter(name);
   }

    @Override
    public void exportBank(String path){
        knowledge.exportBank(path);
    }

    @Override
    public void importBank(String path){
        knowledge.importBank(path);
    }
}