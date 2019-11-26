package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTests {

    @Test
    public void knowCharacterName() {
        Character character = new Character("Lucas");

        String nom = "Lucas";

        assertEquals(nom, character.getName());
    }

    @Test
    public void character1EqualsCharacter2() {
        Character character1 = new Character("Lucas");
        Character character2 = new Character("Lucas");

        assertTrue(character1.equals(character2));
    }

    @Test
    public void character1NotEqualsCharacter2() {
        Character character1 = new Character("Lucas");
        Character character2 = new Character("Tom");
        assertFalse(character1.equals(character2));
    }

    @Test
    public void character1CompareToCharacter2() {
        Character character1 = new Character("Lucas");
        Character character2 = new Character("Tom");

        assertEquals(-8,character1.compareTo(character2));
    }

    @Test
    public void character3CompareToCharacter4() {
        Character character3 = new Character("Lucas");
        Character character4 = new Character("Lucas");

        assertEquals(0,character3.compareTo(character4));
    }
}