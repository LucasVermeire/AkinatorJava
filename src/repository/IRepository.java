package repository;

import models.ICharacter;
import models.IQuestion;
import java.util.List;
import java.util.Set;

/**
 *
 */
public interface IRepository {

    void exportQuestions(List<IQuestion> questions);
    void exportCharacters(Set<ICharacter> characters);

    List<IQuestion> importQuestion();
    Set<ICharacter> importCharacters();
}
