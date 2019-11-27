package models;

import java.beans.PropertyChangeListener;
import java.util.Set;

/**
 *
 */
public interface IKnowledge {
    String getPathImg();
    String getQuestion();
    int knowNumberOfQuestions();
    Set<ICharacter> getSetFinal();
    int getIndex();
    void answerYes ();
    void answerNo();
    void answerIDK();
    boolean knowCharacterFinal();
    String characterFinalToString();
    void addPropertyChangeListener(PropertyChangeListener listener);
    void removePropertyChangeListener(PropertyChangeListener listener);
    void notifyQuestion();
    void notifySolution();
}
