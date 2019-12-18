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
    private static final String PATH_BANK_EXPORT = "bank.json";
    //##############################


    static{
        data = new Data();
    }

    /**
     *
     * @param question
     */
    public static void exportBank(List<IQuestion> questions,Set<ICharacter> characters,IQuestion question) {
        data.exportBank(questions,characters,question, PATH_BANK_EXPORT);
    }

    /**
     *
     * @return
     */
    public static List<IQuestion> importQuestion() {
        return data.importQuestions(PATH_BANK);
    }

    /**
     *
     * @return
     */
    public static Set<ICharacter> importCharacters() {
        return data.importCharacters(PATH_BANK);
    }
}
