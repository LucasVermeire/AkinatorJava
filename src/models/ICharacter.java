package models;

/**
 * <p>L'interface ITheme hérite de Comparable. Elle est composé de 2 signatures de méthodes</p>
 *
 * @author Lucas Vermeire
 * @version 1.0
 *
 */
public interface ICharacter extends Comparable<ICharacter> {
    String getName();
    String getDescription();
}


