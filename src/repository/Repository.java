package repository;

import java.util.List;
import java.util.Set;
import model.IQuestion;
import model.ICharacter;

/**
 *
 */
public class Repository {

    //##############################
    private static Data data;
    private static final String PATH_QUESTIONS = "rsc\\questions.json";
    private static final String PATH_CHARACTERS = "rsc\\personnages.txt";
    //##############################


    static{
        data = new Data();
    }

    public static void exportQuestions(List<IQuestion> questions) {
        data.exportQuestions(questions,PATH_QUESTIONS);
    }

    /**
     *
     * @param characters
     */
    public static void exportCharacters(Set<ICharacter> characters) {
        data.exportCharacters(characters, PATH_CHARACTERS);
    }

    /**
     *
     * @return
     */
    public static List<IQuestion> importQuestion() {
        return data.importQuestions(PATH_QUESTIONS);
    }

    /**
     *
     * @return
     */
    public static Set<ICharacter> importCharacters() {
        return data.importCharacters(PATH_CHARACTERS);
    }
}
