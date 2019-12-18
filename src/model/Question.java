package model;

import java.util.Set;

/**
 *
 */
public class Question implements IQuestion {

    //########################
    private String statement;
    private Set<ICharacter> characters;
    private OperationsSet operations;
    //########################

    /**
     *
     * @param statement
     * @param characters
     */
    public Question(String statement,Set<ICharacter> characters) {
        this.statement = statement;
        this.characters = characters;
        operations = new OperationsSet(characters);
    }

    /**
     *
     * @return
     */
    @Override
    public String getStatementOfQuestions() {
        return statement;
    }

    /**
     *
     * @return
     */
    @Override
    public Set<ICharacter> getSetCharacters(){
        return characters;
    }

    @Override
    public void addCharacter(String character){
        characters.add(new Character(character));
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

    /**
     *
     * @param characters
     * @return
     */
    @Override
    public Set<ICharacter> answerNo(Set<ICharacter> characters) {
        return operations.difference(characters);
    }

    /**
     *
     * @param characters
     * @return
     */
    @Override
    public Set<ICharacter> answerYes(Set<ICharacter> characters) {
        return operations.intersection(characters);
    }
}