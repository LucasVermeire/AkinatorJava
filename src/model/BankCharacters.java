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
        characters = load();
        System.out.println(characters.size());
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
     * @param character
     */
    public void addCharacter(ICharacter character) {
        if(character != null) {
            characters.add(character);
        }
    }

    /**
     *
     * @return
     */
    private Set<ICharacter> load () {
        return Repository.importCharacters();
    }
}
