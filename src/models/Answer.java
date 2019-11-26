package models;

import java.util.*;

public class Answer implements IAnswer{

    private BankQuestions questions;
    private BankCharacters characters;
    private Set<ICharacter> setFinal ;

    public Answer(Set<ICharacter>setFinal) {
        this.setFinal = setFinal;
    }

    @Override
    public void answerYes (int index) {
        IQuestion question = questions.getQuestionByIndex(index);
        setFinal = question.answerYes(new TreeSet<ICharacter>(characters.getBankCharacters()));
    }

    @Override
    public void answerNo(int index) {
        IQuestion question = questions.getQuestionByIndex(index);
        setFinal = question.answerNo(new TreeSet<ICharacter>(characters.getBankCharacters()));
    }
}
