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

    public void addCharacterInQuestion(String nameCharacter,List<String> pastQuestions) {
        int i = 0;

        for(String item : pastQuestions){
            if(item.equals("true")) questions.get(i).addCharacter(nameCharacter);
            i++;
        }
    }

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
}
