package model;

import java.util.*;

/**
 * The Answer class implements the IAnswer interface. It allows me to perform the corresponding set operation
 *  to the user's response.
 */
public class Answer implements IAnswer{

    private BankQuestions questions ;
    private Set<ICharacter> setFinal ;
    private List<String> pastQuestions;

    public Answer(Set<ICharacter> characters,BankQuestions questions,List<String> pastQuestions) {
        this.setFinal = characters;
        this.questions = questions;
        this.pastQuestions = pastQuestions;
    }

    @Override
    public void answerYes (int index) {
        IQuestion question = questions.getQuestionByIndex(index);
        setFinal = question.answerYes(setFinal);
        pastQuestions.add(index,"true");
    }

    @Override
    public void answerNo(int index) {
        IQuestion question = questions.getQuestionByIndex(index);
        setFinal = question.answerNo(setFinal);
        pastQuestions.add(index,"false");
    }

    @Override
    public void answerIDK(int index) {
        pastQuestions.add(index,"none");
    }
}
