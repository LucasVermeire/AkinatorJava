package models;

import java.util.*;

import interfaces.IQuestion;
import interfaces.ITheme;

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
    private Set<ITheme> setFinal;
    private Anwser answer;
    private String questionPath;
    private String characterPath;


    public Knowledge () {
        questions = new BankQuestions(questionPath);
        characters = new BankCharacters(characterPath);
        setFinal = characters.getBankPersonnages();
        answer = new Anwser(setFinal);
    }

    public Set<ITheme> getBankCharacters(){
        return new HashSet<ITheme>(characters.getBankPersonnages());
    }


    public Set<IQuestion> getBankQuestions(){
        return new HashSet<IQuestion>(questions.getBankQuestions());
    }

    public Set<ITheme> getSetFinal(){
        return setFinal;
    }

    public void answerYes (int index) {
        answer.answerYes(index);
    }

    public void answerNo(int index) {
        answer.answerNo(index);
    }
}
