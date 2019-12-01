package models;

import java.util.*;
import repository.Repository;

/**
 *
 */
public class BankCharacters {

    //#################################
    private Set<ICharacter> characters;
    private Repository repository;
    //#################################

    /**
     *
     */
    public BankCharacters () {
        repository = Repository.getInstance();
        characters = load();
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
        export();
    }

    /**
     *
     * @return
     */
    private Set<ICharacter> load () {
        return repository.importCharacters();
    }

    /**
     *
     */
    public void export () {
        repository.exportCharacters(characters);
    }
}
