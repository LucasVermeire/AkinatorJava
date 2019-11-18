package repository;

import java.util.List;
import java.util.Set;
import interfaces.IQuestion;
import interfaces.IRepository;
import interfaces.ITheme;


public class Repository implements IRepository {

    private Data data;
    private static Repository INSTANCE = new Repository();

    private Repository() {
        data = new Data();
    }

    public Repository getInstance() {
        return INSTANCE;
    }

    @Override
    public void exportQuestions(List<IQuestion> bankQuestions,String path) {
        data.exportQuestions(bankQuestions,"rsc\\questions.json");
    }

    @Override
    public void exportCharacters(Set<ITheme> bankPersonnages,String path) {
        data.exportPersonnage(bankPersonnages, "rsc\\personnages.json");
    }

    @Override
    public void importQuestion(List<IQuestion>questions,String path) {
        data.importQuestion(questions, "rsc\\questions.json");
    }

    @Override
    public void importCharacters(Set<ITheme>personnages,String path) {
        data.importPersonnages(personnages, "rsc\\personnages.json");
    }
}
