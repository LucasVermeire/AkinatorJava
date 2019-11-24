package models;

import java.io.Serializable;
import java.util.Set;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * <p>La classe Question définit une question qui est composé d'une clé,d'un énoncé, d'un ensemble de personnage et d'une opération</p>
 *
 * @author Lucas Vermeire
 * @version 1.0
 *
 */
public class Question implements IQuestion,Serializable {

    @SerializedName("Statement")
    @Expose
    private String statement;

    @SerializedName("Personnages")
    @Expose
    private Set<ICharacter> characters;

    private OperationsSet operations;

    public Question(String statement,Set<ICharacter> characters) {
        this.statement = statement;
        this.characters = characters;
        operations = new OperationsSet(characters);
    }


    @Override
    public String getStatementOfQuestions() {
        return statement;
    }

    @Override
    public Set<ICharacter> getSetCharacters(){
        return characters;
    }

    @Override
    public boolean equals(Object question) {
        try{
            String statement = ((IQuestion) question).getStatementOfQuestions();
            return statement.equals(getStatementOfQuestions());
        }catch (IllegalArgumentException ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public Set<ICharacter> answerNo(Set<ICharacter> characters) {
        return operations.difference(characters);
    }

    @Override
    public Set<ICharacter> answerYes(Set<ICharacter> characters) {
        return operations.intersection(characters);
    }
}