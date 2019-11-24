package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * <p>La classe Personnage qui implémente l'interface ITheme, définit un personnage qui est composé d'un nom, d'une description</p>
 *
 * @author Lucas Vermeire
 * @version 1.0
 */
public class Character implements ICharacter, Serializable {

    @SerializedName("Name")
    @Expose
    private String name;

    @SerializedName("Description")
    @Expose
    private String description;

    private String pathImg;

    public Character(String name,String description,String pathImg) {
        this.description = description;
        this.name = name;
        this.pathImg = pathImg;
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
        try{
            return name.equals(((Character)character).getName());
        }catch (IllegalArgumentException ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public int compareTo(ICharacter character) {
        return name.compareTo(character.getName());
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}