package model;

import java.beans.PropertyChangeListener;
import java.util.Set;

public interface IKnowledge extends IKnowledgeData {
    String getImgLastCharacter();
    String getQuestion();
    Set<ICharacter> getSetFinal();
    int getIndex();
    BankCharacters getBankCharacter();
    ICharacter getLastCharacter();
    int knowNumberOfQuestions();
    boolean knowCharacterFinal();
    String characterFinalToString();
    void addPropertyChangeListener(PropertyChangeListener listener);
    void removePropertyChangeListener(PropertyChangeListener listener);
    void notifyQuestion();
    void notifySolution();
}
