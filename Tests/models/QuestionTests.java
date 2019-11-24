package models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.*;
import org.junit.jupiter.api.Test;

public class QuestionTests {


    @Test
    public void knowHisStatement() {

        Set<ICharacter> characters = new TreeSet<ICharacter>();

        characters.add(new Character("Lucas","Etudiant 1", "view/img/characters/billGates.jpg"));

        Question q = new Question("Est ce que votre personnage est un homme?",characters);

        String enonce = "Est ce que votre personnage est un homme?";

        assertEquals(enonce,q.getStatementOfQuestions());
    }


    @Test
    public void knowHisSetCharacters() {

        Set<ICharacter> characters = new TreeSet<ICharacter>();

        characters.add(new Character("Lucas","Etudiant 1","view/img/characters/billGates.jpg"));

        Question q = new Question("Est ce que votre personnage est un vieil homme?",characters);


        Set<Character> personnages2 = new TreeSet<Character>();

        personnages2.add(new Character("Lucas","Etudiant 1","view/img/characters/billGates.jpg"));

        assertEquals(personnages2,q.getSetCharacters());
    }


    @Test
    public void question1EqualsQuestion2() {

        Set<ICharacter> characters = new TreeSet<ICharacter>();

        characters.add(new Character("Lucas","Etudiant 1","view/img/characters/billGates.jpg"));

        Question q1 = new Question("Est ce que votre personnage est petit?",characters);
        Question q2 = new Question("Est ce que votre personnage est petit?",characters);

        assertTrue(q1.equals(q2));
    }

    @Test
    public void question1NotEqualsQuestion2() {

        Set<ICharacter> characters = new TreeSet<ICharacter>();

        characters.add(new Character("Lucas","Etudiant 1","view/img/characters/billGates.jpg"));

        Question q1 = new Question("Est ce que votre personnage est petit?",characters);
        Question q2 = new Question("Est ce que votre personnage est grand",characters);

        assertFalse(q1.equals(q2));
    }
}
