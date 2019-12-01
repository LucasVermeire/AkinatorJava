package models;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Set;
import org.junit.jupiter.api.Test;
import repository.Repository;

class BankCharactersTests {

    @Test
    public void knowHisSetCharacters() {
        Repository repository = Repository.getInstance();

        Set<ICharacter> characters = repository.importCharacters();

        BankCharacters bankCharacters = new BankCharacters();

        assertEquals(characters,bankCharacters.getBankCharacters());
    }

    @Test
    public void addCharacter() {

    }
}
