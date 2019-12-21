package model;

import java.util.*;

/**
 * The Answer class implements the IAnswer interface. It allows me to perform the corresponding set operation
 *  to the user's response.
 */
public class Answer implements IAnswer{

    private BankQuestions questions =  new BankQuestions();
    private Set<ICharacter> setFinal ;

    public Answer(Set<ICharacter> characters) {
        this.setFinal = characters;
    }

    @Override
    public void answerYes (int index) {
        IQuestion question = questions.getQuestionByIndex(index);
        setFinal = question.answerYes(setFinal);
    }

    @Override
    public void answerNo(int index) {
        IQuestion question = questions.getQuestionByIndex(index);
        setFinal = question.answerNo(setFinal);
    }
}
