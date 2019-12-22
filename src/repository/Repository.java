package repository;

import java.util.List;
import java.util.Set;
import model.IQuestion;
import model.ICharacter;

public class Repository {

    private static Data data;

    static{
        data = new Data();
    }

    public static void exportBank(List<IQuestion> questions,Set<ICharacter> characters,String path) {
       data.exportBank(questions,characters, path);
    }

    public static void importBank(String path , List<IQuestion> questions, Set<ICharacter> characters) {
        data.importBank(path,questions,characters);
    }
}
