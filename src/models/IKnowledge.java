package models;

import java.beans.PropertyChangeListener;
import java.util.Set;

public interface IKnowledge {
    Set<ICharacter> getBankCharacters();
    Set<IQuestion> getBankQuestions();
    String getPathImg();
    String getQuestion();
    int knowNumberOfQuestions();
    Set<ICharacter> getSetFinal();
    void answerYes ();
    void answerNo();
    void answerIDK();
    boolean knowCharacterFinal();
    String setFinalToList();
    void addPropertyChangeListener(PropertyChangeListener listener);
    void removePropertyChangeListener(PropertyChangeListener listener);
    void notifyQuestion();
}
