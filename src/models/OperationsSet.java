package models;

import java.util.*;

import interfaces.IOperationsSet;
import interfaces.ITheme;

public class OperationsSet implements IOperationsSet {

    private Set<ITheme> characters;

    public OperationsSet(Set<ITheme> characters) {
        this.characters = characters;
    }

    public Set<ITheme> getSetCharacters(){
        return characters;
    }

    /**
     * <p>La méthode Set<Personnage> intersection(Set<Personnage> p) permet de faire l'intersection
     * entre l'ensemble de tout les personnages et l'ensemble de personnage de la question,
     * si la réponse est "Oui"</p>
     * @param Set<Personnage> p
     * @return Set<Personnage>
     */
    @Override
    public Set<ITheme> intersection(Set<ITheme>p){
        p.retainAll(characters);
        return p;
    }

    /**
     * <p>La méthode Set<Personnage> difference(Set<Personnage> p) permet de faire la différence
     * entre l'ensemble de tout les personnages et l'ensemble de personnage de la question,
     * si la réponse est "Non"</p>
     * @param Set<Personnage> p
     * @return Set<Personnage>
     */
    @Override
    public Set<ITheme> difference(Set<ITheme>p){
        p.removeAll(characters);
        return p;
    }
}
