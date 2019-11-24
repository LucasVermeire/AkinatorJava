package models;

import org.junit.jupiter.api.Test;
import models.Character;
import static org.junit.jupiter.api.Assertions.*;

class CharacterTests {

    @Test
    public void knowCharacterName() {
        Character perso = new Character("Lucas","Etudiant 1","view/img/characters/billGates.jpg");

        String nom = "Lucas";

        assertEquals(nom, perso.getName());
    }

    @Test
    public void knowCharacterDescription() {
        Character perso = new Character("Lucas","Etudiant 1","view/img/characters/billGates.jpg");

        String description = "Etudiant 1";

        assertEquals(description, perso.getDescription());
    }


    @Test
    public void personnage1EqualsPersonnage2() {
        Character perso1 = new Character("Lucas","Etudiant 1","view/img/characters/billGates.jpg");
        Character perso2 = new Character("Lucas","Etudiant 1","view/img/characters/billGates.jpg");

        assertTrue(perso1.equals(perso2));
    }

    @Test
    public void personnage1NotEqualsPersonnage2() {
        Character perso1 = new Character("Lucas","Etudiant 1","view/img/characters/billGates.jpg");
        Character perso2 = new Character("Tom","Etudiant 3","view/img/characters/billGates.jpg");

        assertFalse(perso1.equals(perso2));
    }

    @Test
    public void personnage1CompareToPersonnage2() {
        Character perso1 = new Character("Lucas","Etudiant 1","view/img/characters/billGates.jpg");
        Character perso2 = new Character("Tom","Etudiant 3","view/img/characters/billGates.jpg");

        assertEquals(-8,perso1.compareTo(perso2));
    }

    @Test
    public void personnage3CompareToPersonnage4() {
        Character perso3 = new Character("Lucas","Etudiant 1","view/img/characters/billGates.jpg");
        Character perso4 = new Character("Lucas","Etudiant 1","view/img/characters/billGates.jpg");

        assertEquals(0,perso3.compareTo(perso4));
    }
}