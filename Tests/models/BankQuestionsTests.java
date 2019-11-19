package models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.*;
import org.junit.jupiter.api.Test;
import interfaces.IQuestion;
import interfaces.ITheme;

class BankQuestionsTests {

    @Test
    public void knowHisSetQuestions() {
        List<IQuestion> questions = new ArrayList<IQuestion>();

        BankQuestions BankQuestions = new BankQuestions("rsc\\questions.json");

        assertEquals(questions, BankQuestions.getBankQuestions());
    }

    @Test
    public void addQuestions() {
        Set<ITheme> characters = new TreeSet<ITheme>();
        characters.add(new Character("Lucas","Etudiant 1"));

        List<IQuestion> questions = new ArrayList<IQuestion>();

        Question q = new Question("Est ce un homme ?",characters);

        questions.add(q);

        BankQuestions BankQuestions = new BankQuestions("rsc\\questions.json");

        BankQuestions.addQuestion(q);

        assertEquals(questions,BankQuestions.getBankQuestions());
    }
}
