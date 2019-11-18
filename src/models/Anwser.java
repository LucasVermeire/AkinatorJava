package models;

import java.util.*;
import interfaces.IAnswer;
import interfaces.ITheme;

public class Anwser implements IAnswer{

    private BankQuestions questions;
    private BankCharacters characters;
    private Set<ITheme> setFinal;

    public Anwser(Set<ITheme>setFinal) {
        setFinal = new TreeSet<ITheme>();
    }

    @Override
    public void answerYes (int index) {
        setFinal = questions.getQuestionByIndex(index).answerYes(new TreeSet<ITheme>(characters.getBankPersonnages()));
    }

    @Override
    public void answerNo(int index) {
        setFinal = questions.getQuestionByIndex(index).answerNo(new TreeSet<ITheme>(characters.getBankPersonnages()));
    }
}
