package model;

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
    public void knowImg(){
        Character character = new Character("Lucas Vermeire");

        String img = "Lucas_Vermeire.jpg";

        assertEquals(img,character.getPathImg());
    }

    @Test
    public void character1EqualsCharacter2() {
        Character character1 = new Character("Lucas");
        Character character2 = new Character("Lucas");

        assertEquals(character1, character2);
    }

    @Test
    public void character1NotEqualsCharacter2() {
        Character character1 = new Character("Lucas");
        Character character2 = new Character("Tom");
        assertNotEquals(character1, character2);
    }

    @Test
    public void character1NotEqualsNullCharacter() {
        Character character1 = new Character("Lucas");
        Character character2 = new Character(null);
        assertNotEquals(character1, character2);
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

    @Test
    public void character3CompareToNullCharacter() {
        Character character3 = new Character("Lucas");
        Character character4 = new Character(null);

        assertEquals(-1,character3.compareTo(character4));
    }

    @Test
    public void characterHashCode() {
        Character character1 = new Character("Lucas");
        Character character2 = new Character("Lucas");

        assertEquals((character1.hashCode()),(character2.hashCode()));
    }
}