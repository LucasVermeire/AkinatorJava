package model;

import java.util.Set;

public interface IQuestion {

    /**
     * This method returns the question statement
     * @return statement String
     */
    String getStatementOfQuestions();

    /**
     * This method returns the character set
     * @return  Set<ICharacter>
     */
    Set<ICharacter> getSetCharacters();

    /**
     * This method allows to add a character to the character set of a question
     */
    void addCharacter(String character);

    /**
     * This method returns the character set with the answer YES
     * @param characters Set<ICharacter>
     * @return Set<ICharacter>
     */
    Set<ICharacter> answerNo (Set<ICharacter> characters);

    /**
     * This method returns the character set with the answer NO
     * @param characters Set<ICharacter>
     * @return Set<ICharacter>
     */
    Set<ICharacter> answerYes (Set<ICharacter> characters);
}
