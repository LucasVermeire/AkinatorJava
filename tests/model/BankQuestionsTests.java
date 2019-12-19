package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import repository.Repository;

class BankQuestionsTests {
/*
    @Test
    public void knowHisSetQuestions() {

       List<IQuestion> questions = Repository.importQuestion();

        BankQuestions bankQuestions = new BankQuestions();

        assertEquals(questions,bankQuestions.getBankQuestions());
    }

    @Test
    public void knowQuestionByIndex(){

        BankQuestions bankQuestions = new BankQuestions();

        IQuestion question = bankQuestions.getQuestionByIndex(0);

        Set<ICharacter> characterSet = new HashSet<>();

        characterSet.add(new Character( "Bill Gates"));
        characterSet.add(new Character( "Elon Musk"));
        characterSet.add(new Character( "Jeff Bezos"));
        characterSet.add(new Character( "Mark Zuckerberg"));
        characterSet.add(new Character( "Steve Jobs"));

        assertEquals(new Question("Est ce que votre personnage est un homme ?",characterSet),question);
    }

    @Test
    public void knowQuestionByIndexOversize(){

        BankQuestions bankQuestions = new BankQuestions();

        IQuestion question = bankQuestions.getQuestionByIndex(134);

        Set<ICharacter> characterSet = new HashSet<>();

        characterSet.add(new Character( "Bill Gates"));
        characterSet.add(new Character( "Elon Musk"));
        characterSet.add(new Character( "Jeff Bezos"));
        characterSet.add(new Character( "Mark Zuckerberg"));
        characterSet.add(new Character( "Steve Jobs"));

        assertEquals(null,question);
    }

    @Test
    public void knowQuestionByIndexNegated(){

        BankQuestions bankQuestions = new BankQuestions();

        IQuestion question = bankQuestions.getQuestionByIndex(-12);

        Set<ICharacter> characterSet = new HashSet<>();

        characterSet.add(new Character( "Bill Gates"));
        characterSet.add(new Character( "Elon Musk"));
        characterSet.add(new Character( "Jeff Bezos"));
        characterSet.add(new Character( "Mark Zuckerberg"));
        characterSet.add(new Character( "Steve Jobs"));

        assertEquals(null,question);
    }

    @Test
    public void knowQuestionToString(){
        BankQuestions bankQuestions = new BankQuestions();

        String statement = "Est ce que votre personnage est un homme ?";

        assertEquals(statement,bankQuestions.questionToString(0));
    }

    @Test
    public void knowQuestionToStringIndexOversize(){
        BankQuestions bankQuestions = new BankQuestions();

        assertEquals(null,bankQuestions.questionToString(135));
    }*/
}
