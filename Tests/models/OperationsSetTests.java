package models;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Set;
import java.util.TreeSet;
import org.junit.jupiter.api.Test;


class OperationsSetTests {

    @Test
    public void intersectionSetCharacters() {

        Set<ICharacter> characters1 = new TreeSet<ICharacter>();
        characters1.add(new Character("Lucas"));
        characters1.add(new Character("Bernard"));
        characters1.add(new Character("Yann"));
        characters1.add(new Character("Sam"));


        Set<ICharacter>characters2 = new TreeSet<ICharacter>();
        characters2.add(new Character("Lucas"));
        characters2.add(new Character("Sam"));

        OperationsSet operations = new OperationsSet(characters1);

        Set<ICharacter> intersection = operations.intersection(characters2);

        assertTrue(intersection.contains(new Character("Lucas")));
        assertFalse(intersection.contains(new Character("Bernard")));
        assertFalse(intersection.contains(new Character("Yann")));
        assertTrue(intersection.contains(new Character("Sam")));
    }

    @Test
    public void differenceSetCharacters() {

        Set<ICharacter> characters1 = new TreeSet<ICharacter>();
        characters1.add(new Character("Lucas"));
        characters1.add(new Character("Bernard"));
        characters1.add(new Character("Yann"));

        Set<ICharacter>characters2 = new TreeSet<ICharacter>();
        characters2.add(new Character("Lucas"));
        characters2.add(new Character("Sam"));

        OperationsSet operations = new OperationsSet(characters1);

        Set<ICharacter> difference = operations.difference(characters2);

        assertFalse(difference.contains(new Character("Lucas")));
        assertFalse(difference.contains(new Character("Bernard")));
        assertFalse(difference.contains(new Character("Yann")));
        assertTrue(difference.contains(new Character("Sam")));
    }
}
