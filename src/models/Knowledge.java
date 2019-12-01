package models;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.*;

/**
 *
 */
public class Knowledge implements IKnowledge {

    //##########################################
    private BankQuestions questions;
    private BankCharacters characters;
    private Set<ICharacter> setFinal;
    private Answer answer;
    private PropertyChangeSupport myPcs = new PropertyChangeSupport(this);
    private int index;
    //##########################################

    /**
     *
     */
    public Knowledge () {
        questions = new BankQuestions();
        characters = new BankCharacters();
        setFinal = characters.getBankCharacters();
        answer = new Answer(setFinal);
        index = 0;
    }

    //##########################################

    public ICharacter getLastCharacter(){
        if(knowCharacterFinal()){
            List<ICharacter> characterArrayList = new ArrayList<ICharacter>(setFinal);

            return characterArrayList.get(0);
        }else return new Character("");
    }

    @Override
    public String getImgLastCharacter(){
        return getLastCharacter().getPathImg();
    }

    @Override
    public String getQuestion(){
        return questions.questionToString(index);
    }

    @Override
    public Set<ICharacter> getSetFinal(){
        return setFinal;
    }

    @Override
    public int getIndex(){
        return index;
    }

    @Override
    public BankCharacters getBankCharacter(){
        return characters;
    }


    //##########################################

    public void answerYes () {
        answer.answerYes(index);
        String oldQuestion = getQuestion();
        index++;
        if(index != knowNumberOfQuestions()){
            myPcs.firePropertyChange("Question",oldQuestion,getQuestion());
        }
    }

    public void answerNo() {
        answer.answerNo(index);
        String oldQuestion = getQuestion();
        index++;
        if(index != knowNumberOfQuestions()){
            myPcs.firePropertyChange("Question",oldQuestion,getQuestion());
        }
    }

    public void answerIDK(){
        String oldQuestion = getQuestion();
        index++;
        if(index != knowNumberOfQuestions()){
            myPcs.firePropertyChange("Question",oldQuestion,getQuestion());
        }
    }

    //##########################################

    public int knowNumberOfQuestions(){
        return questions.getBankQuestions().size();
    }

    public boolean knowCharacterFinal(){
        if(setFinal.size()==1)
            return true;
        else
            return false;
    }

    public String characterFinalToString(){
        Set<ICharacter> list = new HashSet<ICharacter>(setFinal);
        String characterFinal = "";
        for (ICharacter item : list) {
            characterFinal += item.getName() + "\n";
        }
        return characterFinal;
    }

    //##########################################

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        myPcs.addPropertyChangeListener(listener);
    }
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        myPcs.removePropertyChangeListener(listener);
    }

    //##########################################

    @Override
    public void notifyQuestion() {
        myPcs.firePropertyChange("Question","",getQuestion());
    }

    @Override
    public void notifySolution(){
        myPcs.firePropertyChange("Solution","", characterFinalToString());
    }

    //#########################################

    @Override
    public void addCharacter(String name) {

    }
}
