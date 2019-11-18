package interfaces;

import java.util.List;
import java.util.Set;

import interfaces.IQuestion;
import interfaces.ITheme;

public interface IRepository {

    void exportQuestions(List<IQuestion> bankQuestions,String path);
    void exportCharacters(Set<ITheme> bankPersonnages,String path);
    void importQuestion(List<IQuestion>questions,String path);
    void importCharacters(Set<ITheme>personnages,String path);
}
