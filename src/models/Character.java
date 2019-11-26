package models;


public class Character implements ICharacter {

    private String name;
    private String pathImg;

    public Character(String name) {
        this.name = name;
        pathImg = (name + ".jpg").replace(" ","_");
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