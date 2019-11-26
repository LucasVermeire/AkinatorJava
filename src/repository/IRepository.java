package repository;

import models.ICharacter;
import models.IQuestion;
import models.Question;

import java.util.List;
import java.util.Set;

public interface IRepository {

    void exportQuestions(List<IQuestion> bankQuestions);
    void exportCharacters(Set<ICharacter> bankPersonnages);

    List<IQuestion> importQuestion();
    Set<ICharacter> importCharacters();
}
