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
    private PropertyChangeSupport myPcs ;
    private int index;
    private List<String> pastQuestion;
    //##########################################

    /**
     *
     */
    public Knowledge () {
        questions = new BankQuestions();
        characters = new BankCharacters();
        setFinal = new HashSet<>(characters.getBankCharacters());
        answer = new Answer(setFinal);
        index = 0;
        pastQuestion = new ArrayList<>();
        myPcs = new PropertyChangeSupport(this);
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
        pastQuestion.add(index,"true");
        answerFirePropertyChange();
    }

    @Override
    public void answerNo() {
        answer.answerNo(index);
        pastQuestion.add(index,"false");
        answerFirePropertyChange();
    }

    @Override
    public void answerIDK() {
        pastQuestion.add(index,"none");
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
    public void addCharacter(String name,String path) {
        characters.addCharacter(name);
        questions.addCharacterInQuestion(name,pastQuestion);
        System.out.println();
    }

    @Override
    public void export(){
        for(int i =0;i<knowNumberOfQuestions();i++){
            Repository.exportBank(questions.getBankQuestions(),characters.getBankCharacters(),questions.getQuestionByIndex(i));
        }
    }

    @Override
    public void restart(){
        this.setFinal = new HashSet<>(characters.getBankCharacters());
        this.answer = new Answer(setFinal);
        this.index = 0;
        this.pastQuestion = new ArrayList<>();
        myPcs = new PropertyChangeSupport(this);
    }
}
