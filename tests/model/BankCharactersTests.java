package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import repository.Repository;

class BankCharactersTests {

    @Test
    public void knowHisSetCharacters() {

        Knowledge knowledge = new Knowledge();

        BankCharacters bankCharacters = new BankCharacters();
        bankCharacters.addCharacter("Chewbacca");
        bankCharacters.addCharacter("Dark Vador");
        bankCharacters.addCharacter("Hans Solo");
        bankCharacters.addCharacter("Kylo Ren");
        bankCharacters.addCharacter("Luke Skywalker");
        bankCharacters.addCharacter("R2 D2");
        bankCharacters.addCharacter("Yoda");
        bankCharacters.addCharacter("C3PO");
        bankCharacters.addCharacter("Finn");
        bankCharacters.addCharacter("Rey");
        bankCharacters.addCharacter("Dark Maul");

        assertEquals(knowledge.getBankCharacter().getBankCharacters(),bankCharacters.getBankCharacters());
    }
}
