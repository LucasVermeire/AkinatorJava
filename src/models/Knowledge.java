package models;


import java.beans.PropertyChangeSupport;
import java.util.*;

public class Knowledge {

    private BankQuestions questions;
    private BankCharacters characters;
    private Set<ICharacter> setFinal;
    private Answer answer;
    private PropertyChangeSupport myPcs = new PropertyChangeSupport(this);
    private int index;

    public Knowledge () {
        questions = new BankQuestions();
        characters = new BankCharacters();
        setFinal = characters.getBankCharacters();
        answer = new Answer(setFinal);
        index = 0;
    }

    public Set<ICharacter> getBankCharacters(){
        return new HashSet<ICharacter>(characters.getBankCharacters());
    }

    public Set<IQuestion> getBankQuestions(){
        return new HashSet<IQuestion>(questions.getBankQuestions());
    }

    private ICharacter getCharacter(){
        if(knowCharacterFinal()){
            List<ICharacter> characterArrayList = new ArrayList<ICharacter>(setFinal);

            return characterArrayList.get(0);
        }else return new Character("****");
    }

    public String getPathImg(){
        return getCharacter().getPathImg();
    }

    public String getQuestion(){
        return questions.questionToString(index);
    }

    public int knowNumberOfQuestions(){
        return questions.getBankQuestions().size();
    }

    public Set<ICharacter> getSetFinal(){
        return setFinal;
    }

    public void answerYes (int i) {
        answer.answerYes(i);
        index++;
    }

    public void answerNo(int i) {
        answer.answerNo(i);
        index++;
    }

    public void answerIDK(){
        index++;
    }

    public boolean knowCharacterFinal(){
        if(setFinal.size()==1)
            return true;
        else
            return false;
    }

    public String setFinalToList(){
        List<ICharacter> list = new ArrayList<ICharacter>(setFinal);
        StringBuilder charactersFinal = new StringBuilder();
        for (ICharacter p : list) charactersFinal.append(p.getName()).append("\n");
        return charactersFinal.toString();
    }
}
