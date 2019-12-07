package model;

import java.util.*;
import repository.Repository;

/**
 *
 */
public class BankQuestions {

    //####################################
    private List<IQuestion> questions;
    //####################################

    /**
     *
     */
    public BankQuestions() {
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
        if(index > questions.size() || index < 0){
            return null;
        }
        return questions.get(index);
    }


    /*
    public void addQuestion(Question question) {
        if(question != null) {
            questions.add(question);
            //export();
        }
    }*/

    /**
     *
     * @param index
     * @return
     */
    public String questionToString(int index) {
        if(index > questions.size() || index < 0){
            return null;
        }
        IQuestion question = questions.get(index);
        return question.getStatementOfQuestions();
    }

    /**
     *
     * @return
     */
    private List<IQuestion> load () {
        return Repository.importQuestion();
    }


    /*
    public void export() {
        Repository.exportQuestions(questions);
    }*/
}
