package model;

/**
 * This class is composed of a name for a character.
 */
public class Character implements ICharacter {

    private String name;
    private String pathImg;

    public Character(String name) {
        this.name = name;
        pathImg = (name+".jpg").replace(" ","_");
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public String getPathImg(){
        return pathImg;
    }

    @Override
    public boolean equals(Object character) {
        try{
            return name.equals(((Character)character).getName());
        }catch (IllegalArgumentException ex){
            return false;
        }
    }

    @Override
    public int compareTo(ICharacter character) {
        if(character.getName()!= null){
            return name.compareTo(character.getName());
        }
        return -1;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}