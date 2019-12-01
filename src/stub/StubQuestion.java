package stub;

import models.ICharacter;
import models.IQuestion;
import models.OperationsSet;
import java.util.Set;

/**
 *
 */
public class StubQuestion {

    //########################
    private String statement;
    private Set<ICharacter> characters;
    private OperationsSet operations;
    //########################

    /**
     * @param statement
     * @param characters
     */
    public StubQuestion(String statement, Set<ICharacter> characters) {
        this.statement = statement;
        this.characters = characters;
        operations = new OperationsSet(characters);
    }

    /**
     * @return
     */

    public String getStatementOfQuestions() {
        return statement;
    }

    /**
     * @return
     */

    public Set<ICharacter> getSetCharacters() {
        return characters;
    }

    public boolean equals(Object question) {
        try {
            String statement = ((IQuestion) question).getStatementOfQuestions();
            return statement.equals(getStatementOfQuestions());
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}