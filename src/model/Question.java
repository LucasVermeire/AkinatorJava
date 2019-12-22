package model;

import java.util.Set;

/**
 * This class is composed of an utterance, a set of characters and an OperationSet object.
 */
public class Question implements IQuestion {

    private String statement;
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
    public void addCharacter(String character){
        if(character != null){
            characters.add(new Character(character));
        }
    }

    @Override
    public Set<ICharacter> answerNo(Set<ICharacter> characters) {
        return operations.difference(characters);
    }

    @Override
    public Set<ICharacter> answerYes(Set<ICharacter> characters) {
        return operations.intersection(characters);
    }

    @Override
    public boolean equals(Object question) {
        try{
            String statement = ((IQuestion) question).getStatementOfQuestions();
            return statement.equals(getStatementOfQuestions());
        }catch (IllegalArgumentException ex){
            ex.printStackTrace();
            return false;
        }
    }
}