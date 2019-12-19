package model;

import java.util.*;
import repository.Repository;

/**
 *
 */
public class BankCharacters {

    //#################################
    private Set<ICharacter> characters;
    //#################################

    /**
     *
     */
    public BankCharacters () {
        characters = Repository.importCharacters();
    }

    /**
     *
     * @return
     */
    public Set<ICharacter> getBankCharacters(){
        return characters;
    }

    /**
     *
     * @param
     */
    public void addCharacter(String name) {
        if(name != null) {
            characters.add(new Character(name));
        }
    }
}
