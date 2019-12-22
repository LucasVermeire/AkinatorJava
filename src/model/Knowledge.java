package model;

import repository.Repository;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class knows the character bank, the question bank. This is the knowledge bank of my application.
 */
public class Knowledge implements IKnowledge {

    private BankQuestions questions;
    private BankCharacters characters;
    private Set<ICharacter> setFinal;
    private Answer answer;
    private PropertyChangeSupport myPcs =new PropertyChangeSupport(this);;
    private int index;
    private List<String> pastQuestions;

    public Knowledge () {
        questions = new BankQuestions();
        characters = new BankCharacters();
        setFinal = new HashSet<>(characters.getBankCharacters());
        answer = new Answer(setFinal,questions);
        index = 0;
        pastQuestions = new ArrayList<>();
        importBank("rsc\\bank.json");
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

    @Override
    public BankQuestions getBankQuestion(){return questions;};

    @Override
    public ICharacter getLastCharacter(){
        if(knowCharacterFinal()){
            List<ICharacter> characterArrayList = new ArrayList<>(setFinal);

            return characterArrayList.get(0);
        }else return new Character("");
    }

    @Override
    public String getImgLastCharacter(){
        return getLastCharacter().getPathImg();
    }


    @Override
    public void answerYes () {
        answer.answerYes(index);
        pastQuestions.add(index,"true");
        answerFirePropertyChange();
    }

    @Override
    public void answerNo() {
        answer.answerNo(index);
        pastQuestions.add(index,"false");
        answerFirePropertyChange();
    }

    @Override
    public void answerIDK() {
        pastQuestions.add(index,"none");
        answerFirePropertyChange();
    }

    private void answerFirePropertyChange(){
        String oldQuestion = getQuestion();
        index++;
        if(index != knowNumberOfQuestions()){
            myPcs.firePropertyChange("Question",oldQuestion,getQuestion());
        }
    }

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
        Set<ICharacter> list = new HashSet<>(setFinal);
        StringBuilder characterFinal = new StringBuilder();
        for (ICharacter item : list) {
            characterFinal.append(item.getName()).append("\n");
        }
        return characterFinal.toString();
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        myPcs.addPropertyChangeListener(listener);
    }
    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        myPcs.removePropertyChangeListener(listener);
    }

    @Override
    public void notifyQuestion() {
        myPcs.firePropertyChange("Question","",getQuestion());
    }

    @Override
    public void notifySolution(){
        myPcs.firePropertyChange("Solution","", characterFinalToString());
    }

    @Override
    public void addCharacter(String name) {
        characters.addCharacter(name);
        questions.addCharacterInQuestion(name, pastQuestions);
    }

    @Override
    public void exportBank(String path){
        for(int i =0;i<knowNumberOfQuestions();++i){
            Repository.exportBank(questions.getBankQuestions(),characters.getBankCharacters(),questions.getQuestionByIndex(i),path);
        }
    }

    @Override
    public void importBank(String path){
        Repository.importBank(path,questions.getBankQuestions(),characters.getBankCharacters());
    }

    @Override
    public void restart(){
        this.setFinal = new HashSet<>(characters.getBankCharacters());
        this.answer = new Answer(setFinal,questions);
        this.index = 0;
        this.pastQuestions = new ArrayList<>();
        myPcs = new PropertyChangeSupport(this);
    }
}