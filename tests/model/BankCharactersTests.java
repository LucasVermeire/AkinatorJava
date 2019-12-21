package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import repository.Repository;

class BankCharactersTests {

    @Test
    public void knowHisSetCharacters() {

        Set<ICharacter> characters = Repository.importCharacters();

        BankCharacters bankCharacters = new BankCharacters();

        assertEquals(characters,bankCharacters.getBankCharacters());
    }

    @Test
    public void addCharacter() {
        Set<ICharacter> characters = new HashSet<>();

        characters.add(new Character("Bill Gates"));
        characters.add(new Character("Elon Musk"));
        characters.add(new Character("Jeff Bezos"));
        characters.add(new Character("Mark Zuckerberg"));
        characters.add(new Character("Steve Jobs"));
        characters.add(new Character("Emma Watson"));
        characters.add(new Character("Michelle Obama"));
        characters.add(new Character("Rihanna"));
        characters.add(new Character("Lucas Vermeire"));

        BankCharacters bankCharacters = new BankCharacters();

        bankCharacters.addCharacter("Lucas Vermeire");

        assertEquals(characters,bankCharacters.getBankCharacters());
    }
}
