package models;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Set;
import java.util.TreeSet;
import org.junit.jupiter.api.Test;


class OperationsSetTests {


    @Test
    public void intersectionSetCharacters() {


        Set<ICharacter> characters = new TreeSet<ICharacter>();
        characters.add(new Character("Lucas","Etudiant 1", "view/img/characters/billGates.jpg"));
        characters.add(new Character("Bernard","Etudiant 4", "view/img/characters/JeffBezos.jpg"));
        characters.add(new Character("Yann","Etudiant 7","view/img/characters/billGates.jpg"));
        characters.add(new Character("Sam","Etudiant 6","view/img/characters/billGates.jpg"));


        Set<ICharacter>personnages2 = new TreeSet<ICharacter>();
        personnages2.add(new Character("Lucas","Etudiant 1","view/img/characters/billGates.jpg"));
        personnages2.add(new Character("Sam","Etudiant 6","view/img/characters/billGates.jpg"));

        OperationsSet operations = new OperationsSet(characters);

        Set<ICharacter> persoInters = operations.intersection(personnages2);

        assertTrue(persoInters.contains(new Character("Lucas","Etudiant 1","view/img/characters/billGates.jpg")));
        assertFalse(persoInters.contains(new Character("Bernard","Etudiant 4","view/img/characters/billGates.jpg")));
        assertFalse(persoInters.contains(new Character("Yann","Etudiant 7","view/img/characters/billGates.jpg")));
        assertTrue(persoInters.contains(new Character("Sam","Etudiant 6","view/img/characters/billGates.jpg")));
    }

    @Test
    public void differenceSetCharacters() {

        Set<ICharacter> characters = new TreeSet<ICharacter>();
        characters.add(new Character("Lucas","Etudiant 1","view/img/characters/billGates.jpg"));
        characters.add(new Character("Bernard","Etudiant 4","view/img/characters/billGates.jpg"));
        characters.add(new Character("Yann","Etudiant 7","view/img/characters/billGates.jpg"));

        Set<ICharacter>personnages2 = new TreeSet<ICharacter>();
        personnages2.add(new Character("Lucas","Etudiant 1","view/img/characters/billGates.jpg"));
        personnages2.add(new Character("Sam","Etudiant 6","view/img/characters/billGates.jpg"));

        OperationsSet operations = new OperationsSet(characters);

        Set<ICharacter> persoDiff = operations.difference(personnages2);

        assertFalse(persoDiff.contains(new Character("Lucas","Etudiant 1","view/img/characters/billGates.jpg")));
        assertFalse(persoDiff.contains(new Character("Bernard","Etudiant 4","view/img/characters/billGates.jpg")));
        assertFalse(persoDiff.contains(new Character("Yann","Etudiant 7","view/img/characters/billGates.jpg")));
        assertTrue(persoDiff.contains(new Character("Sam","Etudiant 6","view/img/characters/billGates.jpg")));
    }
}
