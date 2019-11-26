package models;

import java.util.*;
import repository.Repository;


public class BankQuestions {

    private List<IQuestion> questions;
    private Repository repository;

    public BankQuestions() {
        questions = new ArrayList<IQuestion>();
        repository = Repository.getInstance();
        questions = load();
    }

    public List<IQuestion> getBankQuestions(){
        return questions;
    }

    public IQuestion getQuestionByIndex (int index) {
        return questions.get(index);
    }

    public void addQuestion(Question question) {
        if(question != null) {
            questions.add(question);
        }
        //export();
    }

    public String questionToString(int index) {
        IQuestion question = questions.get(index);
        return question.getStatementOfQuestions();
    }


    private List<IQuestion> load () {
        return repository.importQuestion();
    }

    public void export() {
        repository.exportQuestions(questions);
    }
}
