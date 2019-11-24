package models;

import java.util.*;

import repository.Repository;

/**
 * <p>La classe BankCharacters définit une banque de personnages.
 * Elle est composé d'un ensemble de personnages</p>
 *
 *
 * @author Lucas Vermeire
 * @version 1.0
 *
 */
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
