package models;

import java.util.*;

import interfaces.IRepository;
import interfaces.ITheme;
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

    private Set<ITheme> characters;
    private Repository repository ;
    private String path;

    public BankCharacters (String path) {
        this.path = path;
        characters = new TreeSet<ITheme>();
        //load();
    }

    public Set<ITheme> getBankCharacters(){
        return characters;
    }

    public void addCharacter(Character p) {
        if(p != null) {
            characters.add(p);
        }
        //export();
    }

    private void load () {
        repository.getInstance().importCharacters(characters, path);
    }

    public void export () {
        repository.exportCharacters(characters, path);
    }
}
