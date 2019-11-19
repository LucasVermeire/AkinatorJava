package models;

import java.io.Serializable;
import java.util.Set;
import interfaces.IQuestion;
import interfaces.ITheme;

/**
 * <p>La classe Question définit une question qui est composé d'une clé,d'un énoncé, d'un ensemble de personnage et d'une opération</p>
 *
 * @author Lucas Vermeire
 * @version 1.0
 *
 */
public class Question implements IQuestion,Serializable {

    private static final long serialVersionUID = 1L;
    private String statement;
    private Set<ITheme> characters;
    private OperationsSet operations;

    public Question(String statement,Set<ITheme> characters) {
        this.statement = statement;
        this.characters = characters;
        operations = new OperationsSet(characters);
    }


    @Override
    public String getStatementOfQuestions() {
        return statement.toLowerCase();
    }

    @Override
    public Set<ITheme> getSetCharacters(){
        return characters;
    }

    @Override
    public boolean equals(Object question) {
        return ((IQuestion) question).getStatementOfQuestions().equals(getStatementOfQuestions());
    }

    @Override
    public Set<ITheme> answerNo(Set<ITheme> p) {
        return operations.difference(p);
    }

    @Override
    public Set<ITheme> answerYes(Set<ITheme> p) {
        return operations.intersection(p);
    }
}