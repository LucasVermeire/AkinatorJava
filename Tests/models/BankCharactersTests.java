package models;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Set;
import java.util.TreeSet;
import org.junit.jupiter.api.Test;

class BankCharactersTests {

    @Test
    public void knowHisSetCharacters() {
        Set<ICharacter> characters = new TreeSet<ICharacter>();

        BankCharacters bankCharacters = new BankCharacters();

        assertEquals(characters, bankCharacters.getBankCharacters());
    }

    @Test
    public void addCharacter() {
        Set<ICharacter> characters = new TreeSet<ICharacter>();

        Character c = new Character("Lucas","Etudiant","view/img/characters/billGates.jpg");

        characters.add(c);

        BankCharacters bankCharacters = new BankCharacters();

        bankCharacters.addCharacter(c);

        assertEquals(characters,bankCharacters.getBankCharacters());
    }
}
