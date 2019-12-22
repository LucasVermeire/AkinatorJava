package model;

import java.util.*;
import repository.Repository;

/**
 * This class imports the application questions from the json file in the knowledge bank.
 * It allows me to return a question statement, a specific question, and add a character to the question character set.
 */
public class BankQuestions {

    private List<IQuestion> questions;

    public BankQuestions() {
        questions = new ArrayList<>();
    }

    /**
     * This method returns the list of questions
     * @return questions List<IQuestion>
     */
    public List<IQuestion> getBankQuestions(){
        return questions;
    }

    /**
     * This method returns the question from the list with as index the one in parameter
     * @param index int
     * @return IQuestion
     */
    public IQuestion getQuestionByIndex (int index) {
        if(index > questions.size() || index < 0){
            return null;
        }
        return questions.get(index);
    }

    /**
     * This method makes it possible to know to which question the person answered yes.
     * @param nameCharacter String
     * @param pastQuestions List<String>
     */
    public void addCharacterInQuestion(String nameCharacter, List<String> pastQuestions) {
        int i = 0;

        for(String item : pastQuestions){
            if(item.equals("true")){
                questions.get(i).addCharacter(nameCharacter);
                System.out.println( questions.get(i).getSetCharacters().size());
            }
            i++;
        }
    }

    /**
     * This method returns the question statement corresponding to the index in parameter
     * @param index int
     * @return String statementOfQuestion
     */
    public String questionToString(int index) {
        if(index > questions.size() || index < 0){
            return " ";
        }else{
            IQuestion question = questions.get(index);
            return question.getStatementOfQuestions();
        }
    }
}