package models;

import java.util.*;

import interfaces.IQuestion;
import repository.Repository;

/**
 * <p>La classe BankQuestions définit une banque de question.
 * Elle est composé d'un ensemble de questions</p>
 *
 * @author Lucas Vermeire
 * @version 1.0
 *
 */
public class BankQuestions {

    private List<IQuestion> questions;
    private Repository repository ;
    private String path;

    public BankQuestions(String path) {
        this.path = path;
        questions = new ArrayList<IQuestion>();
        //load();
    }

    public List<IQuestion> getBankQuestions(){
        return questions;
    }

    public IQuestion getQuestionByIndex (int index) {
        return questions.get(index);
    }

    public void addQuestion(Question q) {
        if(q != null) {
            questions.add(q);
        }
        //export();
    }

    private void load () {
        repository.getInstance().importQuestion(questions, path);
    }

    public void export() {
        repository.getInstance().exportQuestions(questions, path);
    }
}
