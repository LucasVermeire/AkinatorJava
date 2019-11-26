package models;

import java.util.*;
import repository.Repository;

public class BankCharacters {

    private Set<ICharacter> characters;
    private Repository repository;

    public BankCharacters () {
        characters = new TreeSet<ICharacter>();
        repository = Repository.getInstance();
        //characters = load();
    }

    public Set<ICharacter> getBankCharacters(){
        return characters;
    }

    public void addCharacter(Character character) {
        if(character != null) {
            characters.add(character);
        }
        //export();
    }

    private Set<ICharacter> load () {
        return repository.importCharacters();
    }

    public void export () {
        repository.exportCharacters(characters);
    }
}
