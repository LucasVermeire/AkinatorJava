package model;

import java.util.Set;

public interface IOperationsSet {

    /**
     * This method returns the character set following an intersection operation with the character set in parameter
     * @param characters Set<ICharacter>
     * @return Set<ICharacter>
     */
    Set<ICharacter> intersection(Set<ICharacter>characters);

    /**
     * This method returns the character set following a difference operation with the character set in parameter
     * @param characters Set<ICharacter>
     * @return Set<ICharacter>
     */
    Set<ICharacter> difference(Set<ICharacter>characters);
}
