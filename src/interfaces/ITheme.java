package interfaces;

/**
 * <p>L'interface ITheme hérite de Comparable. Elle est composé de 2 signatures de méthodes</p>
 *
 * @author Lucas Vermeire
 * @version 1.0
 *
 */
public interface ITheme extends Comparable<ITheme> {
    String getName();
    String getDescription();
}


