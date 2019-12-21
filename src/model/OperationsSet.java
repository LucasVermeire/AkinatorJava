package model;

import java.util.*;

/**
 * This class is composed of a set of characters. It allows to carry out the two following operations
 * --> the difference and the intersection.
 */
public class OperationsSet implements IOperationsSet {

    private Set<ICharacter> characters;

    public OperationsSet(Set<ICharacter> characters) {
        this.characters = characters;
    }

    @Override
    public Set<ICharacter> intersection(Set<ICharacter>characters){
        characters.retainAll(this.characters);
        return characters;
    }

    @Override
    public Set<ICharacter> difference(Set<ICharacter>characters){
        characters.removeAll(this.characters);
        return characters;
    }
}
