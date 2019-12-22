package stub;

import model.Character;
import model.ICharacter;
import model.Question;
import org.junit.jupiter.api.Test;
import java.util.Set;
import java.util.TreeSet;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StubQuestionTest {

    @Test
    public void knowHisStatement() {

        Set<ICharacter> characters = new TreeSet<ICharacter>();

        characters.add(new Character("Lucas"));

        Question q = new Question("Est ce que votre personnage est un homme?",characters);

        String statement = "Est ce que votre personnage est un homme?";

        assertEquals(statement,q.getStatementOfQuestions());
    }
}
