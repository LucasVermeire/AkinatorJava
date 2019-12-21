package model;


public interface ICharacter extends Comparable<ICharacter> {

    /**
     * This method returns the name of the character
     * @return name String
     */
    String getName();


    /**
     * This method returns the path of the character image
     * @return pathImg String
     */
    String getPathImg();
}


