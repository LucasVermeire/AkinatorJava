package model;

import java.util.Set;

public interface IQuestion {
    Set<ICharacter> answerNo (Set<ICharacter> characters);
    Set<ICharacter> answerYes (Set<ICharacter> characters);
    String getStatementOfQuestions();
    Set<ICharacter> getSetCharacters();
}
