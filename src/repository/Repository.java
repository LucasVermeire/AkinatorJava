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
    private static final String PATH_BANK = "rsc\\bank.json";
    //##############################


    static{
        data = new Data();
    }

    /**
     *
     * @param question
     */
    public static void exportBank(List<IQuestion> questions,Set<ICharacter> characters,IQuestion question,String path) {
       data.exportBank(questions,characters,question, path);
    }

    /**
     *
     * @return
     */
    public static void importBank(String path , List<IQuestion> questions, Set<ICharacter> characters) {
        data.importBank(path,questions,characters);
    }

    public static List<IQuestion> importQuestion() {
        return data.importQuestions(PATH_BANK);
    }

    public static Set<ICharacter> importCharacters() {
        return data.importCharacters(PATH_BANK);
    }


}
