package models;

import java.beans.PropertyChangeListener;
import java.util.Set;

/**
 *
 */
public interface IKnowledge {
    String getPathImg();
    String getQuestion();
    Set<ICharacter> getSetFinal();
    int getIndex();
    BankCharacters getBankCharacter();

    int knowNumberOfQuestions();
    void answerYes ();
    void answerNo();
    void answerIDK();

    boolean knowCharacterFinal();
    String characterFinalToString();

    void addPropertyChangeListener(PropertyChangeListener listener);
    void removePropertyChangeListener(PropertyChangeListener listener);

    void notifyQuestion();
    void notifySolution();

    void addCharacter(String name);
}
