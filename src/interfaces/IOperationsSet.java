package interfaces;

import java.util.Set;

public interface IOperationsSet {

    Set<ITheme> intersection(Set<ITheme>p);
    Set<ITheme> difference(Set<ITheme>p);
}
