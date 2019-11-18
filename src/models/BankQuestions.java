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
        load();
    }

    public List<IQuestion> getBankQuestions(){
        return questions;
    }

    public IQuestion getQuestionByIndex (int index) {
        return questions.get(index);
    }


    /**
     * <p>La méthode void addQuestions(Question q) ajoute une question dans la banque de question si elle n'est pas null
     * et export les questions</p>
     * @param q
     */
    public void addQuestion(Question q) {
        if(q != null) {
            questions.add(q);
        }
        export();
    }


    /**
     * <p>La méthode load permet de charger/d'importer l'ensemble des questions</p>
     * @param String pathQuestion
     */
    private void load () {
        repository.getInstance().importQuestion(questions, path);
    }

    /**
     * <p>La méthode export permet d'exporter/de sauvegarder l'ensemble des questions</p>
     * @param String path
     */
    public void export() {
        repository.getInstance().exportQuestions(questions, path);
    }
}
