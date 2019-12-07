package model;

/**
 *
 */
public class Character implements ICharacter {

    //###################
    private String name;
    private String pathImg;
    //###################

    /**
     *
     * @param name
     */
    public Character(String name) {
        this.name = name;
        pathImg = (name + ".jpg").replace(" ","_");
    }

    /**
     *
     * @return
     */
    @Override
    public String getName(){
        return name;
    }

    /**
     *
     * @return
     */
    @Override
    public String getPathImg(){
        return pathImg;
    }

    /**
     *
     * @param character
     * @return
     */
    @Override
    public boolean equals(Object character) {
        try{
            return name.equals(((Character)character).getName());
        }catch (IllegalArgumentException ex){
            ex.printStackTrace();
            return false;
        }
    }

    /**
     *
     * @param character
     * @return
     */
    @Override
    public int compareTo(ICharacter character) {
        return name.compareTo(character.getName());
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        return name.hashCode();
    }
}