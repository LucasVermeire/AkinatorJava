package models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.Test;
import repository.Repository;

class BankQuestionsTests {

    @Test
    public void knowHisSetQuestions() {
        Repository repository = Repository.getInstance();

        List<IQuestion> questions = repository.importQuestion();

        BankQuestions bankQuestions = new BankQuestions();

        assertEquals(questions,bankQuestions.getBankQuestions());
    }

    @Test
    public void addQuestions() {

    }
}
