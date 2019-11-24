package models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.*;
import org.junit.jupiter.api.Test;

class BankQuestionsTests {

    @Test
    public void knowHisSetQuestions() {
        List<IQuestion> questions = new ArrayList<IQuestion>();

        BankQuestions BankQuestions = new BankQuestions();

        assertEquals(questions, BankQuestions.getBankQuestions());
    }

    @Test
    public void addQuestions() {
        Set<ICharacter> characters = new TreeSet<ICharacter>();
        characters.add(new Character("Lucas","Etudiant 1","view/img/characters/billGates.jpg"));

        List<IQuestion> questions = new ArrayList<IQuestion>();

        Question q = new Question("Est ce un homme ?",characters);

        questions.add(q);

        BankQuestions BankQuestions = new BankQuestions();

        BankQuestions.addQuestion(q);

        assertEquals(questions,BankQuestions.getBankQuestions());
    }
}
