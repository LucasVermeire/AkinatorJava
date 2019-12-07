package model;

import java.util.*;

/**
 *
 */
public class Answer implements IAnswer{

    //#################################
    private BankQuestions questions =  new BankQuestions();
    private Set<ICharacter> setFinal ;
    //#################################

    /**
     *
     * @param characters
     */
    public Answer(Set<ICharacter> characters) {
        this.setFinal = characters;
    }

    /**
     *
     * @param index
     */
    @Override
    public void answerYes (int index) {
        IQuestion question = questions.getQuestionByIndex(index);
        setFinal = question.answerYes(setFinal);
    }

    /**
     *
     * @param index
     */
    @Override
    public void answerNo(int index) {
        IQuestion question = questions.getQuestionByIndex(index);
        setFinal = question.answerNo(setFinal);
    }
}
