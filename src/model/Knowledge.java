package model;

import repository.Repository;

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

    @Override
    public void answerYes () {
        answer.answerYes(index);
        answerFirePropertyChange();
    }

    @Override
    public void answerNo() {
        answer.answerNo(index);
        answerFirePropertyChange();
    }

    @Override
    public void answerIDK(){
        answerFirePropertyChange();
    }

    private void answerFirePropertyChange(){
        String oldQuestion = getQuestion();
        index++;
        if(index != knowNumberOfQuestions()){
            myPcs.firePropertyChange("Question",oldQuestion,getQuestion());
        }
    }

    //##########################################

    @Override
    public int knowNumberOfQuestions(){
        List<IQuestion> bank = questions.getBankQuestions();
        return bank.size();
    }

    @Override
    public boolean knowCharacterFinal(){
        return setFinal.size() == 1;
    }

    @Override
    public String characterFinalToString(){
        Set<ICharacter> list = new HashSet<ICharacter>(setFinal);
        String characterFinal = "";
        for (ICharacter item : list) {
            characterFinal += item.getName() + "\n";
        }
        return characterFinal;
    }

    //##########################################

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        myPcs.addPropertyChangeListener(listener);
    }
    @Override
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
        //TODO
    }

    @Override
    public void export(){
        Repository.exportBank(questions.getBankQuestions(),questions.getQuestionByIndex(0));
    }
}
