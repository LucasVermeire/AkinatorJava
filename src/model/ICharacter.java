package model;

/**
 *
 */
public interface ICharacter extends Comparable<ICharacter> {
    String getName();
    String getPathImg();
    void setPathImg(String path);
}


