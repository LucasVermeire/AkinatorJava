package models;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Set;
import java.util.TreeSet;
import org.junit.jupiter.api.Test;
import interfaces.ITheme;

class BankCharactersTests {

    @Test
    public void knowHisSetCharacters() {
        Set<ITheme> characters = new TreeSet<ITheme>();

        BankCharacters bankCharacters = new BankCharacters("rsc\\personnages.json");

        assertEquals(characters, bankCharacters.getBankCharacters());
    }

    @Test
    public void addCharacter() {
        Set<ITheme> characters = new TreeSet<ITheme>();

        Character c = new Character("Lucas","Etudiant");

        characters.add(c);

        BankCharacters bankCharacters = new BankCharacters("rsc\\personnages.json");

        bankCharacters.addCharacter(c);

        assertEquals(characters,bankCharacters.getBankCharacters());
    }
}
