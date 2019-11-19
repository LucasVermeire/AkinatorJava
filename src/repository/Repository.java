package repository;

import java.util.List;
import java.util.Set;
import interfaces.IQuestion;
import interfaces.IRepository;
import interfaces.ITheme;


public class Repository implements IRepository {

    private Data data;
    private static Repository INSTANCE = new Repository();
    private final String PATH_QUESTIONS = "rsc\\questions.json";
    private final String PATH_CHARACTERS = "rsc\\personnages.json";

    private Repository() {
        data = new Data();
    }

    public Repository getInstance() {
        return INSTANCE;
    }

    public String getPATH_QUESTIONS(){
        return PATH_QUESTIONS;
    }

    public String getPATH_CHARACTERS(){
        return PATH_CHARACTERS;
    }

    @Override
    public void exportQuestions(List<IQuestion> bankQuestions,String path) {
        data.exportQuestions(bankQuestions,PATH_QUESTIONS);
    }

    @Override
    public void exportCharacters(Set<ITheme> bankCharacters,String path) {
        data.exportCharacters(bankCharacters, PATH_CHARACTERS);
    }

    @Override
    public void importQuestion(List<IQuestion>questions,String path) {
        data.importQuestion(questions, "rsc\\questions.json");
    }

    @Override
    public void importCharacters(Set<ITheme>characters,String path) {
        data.importPersonnages(characters, "rsc\\personnages.json");
    }
}
