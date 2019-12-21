package model;

import java.util.*;
import repository.Repository;

/**
 * This class imports the characters of the application from the json file of the knowledge bank.
 * It allows me to add a character to the character bank
 */
public class BankCharacters {

    private Set<ICharacter> characters;

    public BankCharacters () {
        characters = Repository.importCharacters();
    }

    /**
     * This method returns the character set
     * @return characters Set<ICharacter>
     */
    public Set<ICharacter> getBankCharacters(){
        return characters;
    }

    /**
     * This method allows the addition of a character with the name in parameter
     * @param name String
     */
    public void addCharacter(String name) {
        if(name != null) {
            characters.add(new Character(name));
        }
    }
}
