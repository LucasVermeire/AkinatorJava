package model;

import java.util.Set;

public interface IOperationsSet {

    Set<ICharacter> intersection(Set<ICharacter>characters);
    Set<ICharacter> difference(Set<ICharacter>characters);
}
