package models;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Set;
import java.util.TreeSet;
import org.junit.jupiter.api.Test;
import interfaces.ITheme;
import models.BankCharacters;
import models.Character;

class BankCharactersTests {

    @Test
    public void knowHisSetPersonnages() {
        Set<ITheme> characters = new TreeSet<ITheme>();

        BankCharacters bankPersonnages = new BankCharacters("rsc\\personnages.json");

        assertEquals(characters, bankPersonnages.getBankPersonnages());

        //TODO
    }

    @Test
    public void addPersonnage() {
        Set<ITheme> characters = new TreeSet<ITheme>();

        Character c = new Character("Lucas","Etudiant");

        characters.add(c);

        BankCharacters bankPersonnages = new BankCharacters("rsc\\personnages.json");

        bankPersonnages.addCharacter(c);

        assertEquals(characters,bankPersonnages.getBankPersonnages());
    }
}
