package models;

import interfaces.ITheme;

/**
 * <p>La classe Personnage qui implémente l'interface ITheme, définit un personnage qui est composé d'un nom, d'une description</p>
 *
 * @author Lucas Vermeire
 * @version 1.0
 */
public class Character implements ITheme {

    private String name;
    private String description;

    public Character(String name,String description) {
        this.description = description;
        this.name = name;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object character) {
        return name.equals(((Character)character).getName());
    }

    @Override
    public int compareTo(ITheme t) {
        try {
            return name.compareTo(t.getName());
        }catch(ClassCastException ex) {
            System.out.println("Erreur de comparaison");
        }
        return 0;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}