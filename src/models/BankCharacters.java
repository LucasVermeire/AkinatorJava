package models;

import java.util.*;

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
        load();
    }

    public Set<ITheme> getBankPersonnages (){
        return characters;
    }

    /**
     * <p>La méthode void addPersonnage(Personnage p) permet d'ajouter un personnage à la banque si il n'est pas null</p>
     * @param p
     */
    public void addCharacter(Character p) {
        if(p != null) {
            characters.add(p);
        }
        export();
    }

    /**
     * <p>La méthode load permet de charger/d'importer l'ensemble des personnages</p>
     * @param String pathCharacter
     */
    private void load () {
        repository.getInstance().importCharacters(characters, path);
    }

    /**
     * <p>La méthode export permet d'exporter/de sauvegarder l'ensemble des personnages</p>
     * @param String path
     */
    public void export () {
        repository.exportCharacters(characters, path);
    }
}
