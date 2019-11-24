package models;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.*;

/**
 * <p>La classe Knowledge définit la connaissance des différentes banques. Elle est composé d'une banque de personnages et d'une banque de questions</p>
 *
 * @author Lucas Vermeire
 * @version 1.0
 *
 */
public class Knowledge {

    private BankQuestions questions;
    private BankCharacters characters;
    private Set<ICharacter> setFinal;
    private Answer answer;
    private PropertyChangeSupport myPcs = new PropertyChangeSupport(this);

    public Knowledge () {
        questions = new BankQuestions();
        characters = new BankCharacters();
        setFinal = characters.getBankCharacters();
        answer = new Answer(setFinal);
        myPcs.firePropertyChange("setFinal",5,setFinal);
    }

    public Set<ICharacter> getBankCharacters(){
        return new HashSet<ICharacter>(characters.getBankCharacters());
    }


    public Set<IQuestion> getBankQuestions(){
        return new HashSet<IQuestion>(questions.getBankQuestions());
    }

    public Set<ICharacter> getSetFinal(){
        return setFinal;
    }

    public void answerYes (int index) {
        answer.answerYes(index);
    }

    public void answerNo(int index) {
        answer.answerNo(index);
    }

    public void addPropertyChangeListener(PropertyChangeListener l){
        myPcs.addPropertyChangeListener(l);
    }
}
