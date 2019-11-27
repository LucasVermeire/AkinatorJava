package repository;

import java.util.List;
import java.util.Set;
import models.IQuestion;
import models.ICharacter;

public class Repository implements IRepository {

    private Data data;
    private static Repository INSTANCE = new Repository();
    private final String PATH_QUESTIONS = "rsc\\questions.json";
    private final String PATH_CHARACTERS = "rsc\\personnages.txt";

    private Repository() {
        data = new Data();
    }

    public static Repository getInstance() {
        return INSTANCE;
    }

    @Override
    public void exportQuestions(List<IQuestion> questions) {
        data.exportQuestions(questions,PATH_QUESTIONS);
    }

    @Override
    public void exportCharacters(Set<ICharacter> characters) {
        data.exportCharacters(characters, PATH_CHARACTERS);
    }

    @Override
    public List<IQuestion> importQuestion() {
        return data.importQuestions(PATH_QUESTIONS);
    }

    @Override
    public Set<ICharacter> importCharacters() {
        return data.importCharacters(PATH_CHARACTERS);
    }
}
