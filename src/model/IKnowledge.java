package model;

import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.Set;

public interface IKnowledge extends IKnowledgeData {

    /**
     * This method returns the question statement with the index "X"
     * @return String statement
     */
    String getQuestion();

    /**
     * This method returns the final character Set
     * @return Set<ICharacter>
     */
    Set<ICharacter> getSetFinal();

    /**
     * This method returns the index
     * @return int index
     */
    int getIndex();

    /**
     * This method returns the bank of characters
     * @return BankCharacters
     */
    BankCharacters getBankCharacter();

    BankQuestions getBankQuestion();

    /**
     * This method returns the last character
     * @return ICharacter
     */
    ICharacter getLastCharacter();

    /**
     * This method returns the last character image
     * @return String pathImage
     */
    String getImgLastCharacter();

    List<String> getPastQuestions();

    /**
     * This method returns the number of questions
     * @return int
     */
    int knowNumberOfQuestions();

    /**
     * This method returns true if there is only one character left in the final set
     * @return boolean
     */
    boolean knowCharacterFinal();

    /**
     * This method returns the last character name
     * @return boolean
     */
    String characterFinalToString();

    void addPropertyChangeListener(PropertyChangeListener listener);
    void removePropertyChangeListener(PropertyChangeListener listener);
    void notifyQuestion();
    void notifySolution();
}
