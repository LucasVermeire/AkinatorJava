package models;

import java.util.*;
import repository.Repository;

/**
 *
 */
public class BankQuestions {

    //####################################
    private List<IQuestion> questions;
    private Repository repository;
    //####################################

    /**
     *
     */
    public BankQuestions() {
        repository = Repository.getInstance();
        questions = load();
    }

    /**
     *
     * @return
     */
    public List<IQuestion> getBankQuestions(){
        return questions;
    }

    /**
     *
     * @param index
     * @return
     */
    public IQuestion getQuestionByIndex (int index) {
        return questions.get(index);
    }

    /**
     *
     * @param question
     */
    public void addQuestion(Question question) {
        if(question != null) {
            questions.add(question);
        }
        //export();
    }

    /**
     *
     * @param index
     * @return
     */
    public String questionToString(int index) {
        IQuestion question = questions.get(index);
        return question.getStatementOfQuestions();
    }

    /**
     *
     * @return
     */
    private List<IQuestion> load () {
        return repository.importQuestion();
    }

    /**
     *
     */
    public void export() {
        repository.exportQuestions(questions);
    }
}
