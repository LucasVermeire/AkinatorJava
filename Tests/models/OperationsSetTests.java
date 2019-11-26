package models;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Set;
import java.util.TreeSet;
import org.junit.jupiter.api.Test;


class OperationsSetTests {


    @Test
    public void intersectionSetCharacters() {


        Set<ICharacter> characters = new TreeSet<ICharacter>();
        characters.add(new Character("Lucas"));
        characters.add(new Character("Bernard"));
        characters.add(new Character("Yann"));
        characters.add(new Character("Sam"));


        Set<ICharacter>personnages2 = new TreeSet<ICharacter>();
        personnages2.add(new Character("Lucas"));
        personnages2.add(new Character("Sam"));

        OperationsSet operations = new OperationsSet(characters);

        Set<ICharacter> persoInters = operations.intersection(personnages2);

        assertTrue(persoInters.contains(new Character("Lucas")));
        assertFalse(persoInters.contains(new Character("Bernard")));
        assertFalse(persoInters.contains(new Character("Yann")));
        assertTrue(persoInters.contains(new Character("Sam")));
    }

    @Test
    public void differenceSetCharacters() {

        Set<ICharacter> characters = new TreeSet<ICharacter>();
        characters.add(new Character("Lucas"));
        characters.add(new Character("Bernard"));
        characters.add(new Character("Yann"));

        Set<ICharacter>personnages2 = new TreeSet<ICharacter>();
        personnages2.add(new Character("Lucas"));
        personnages2.add(new Character("Sam"));

        OperationsSet operations = new OperationsSet(characters);

        Set<ICharacter> persoDiff = operations.difference(personnages2);

        assertFalse(persoDiff.contains(new Character("Lucas")));
        assertFalse(persoDiff.contains(new Character("Bernard")));
        assertFalse(persoDiff.contains(new Character("Yann")));
        assertTrue(persoDiff.contains(new Character("Sam")));
    }
}
