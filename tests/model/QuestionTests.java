package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.*;
import org.junit.jupiter.api.Test;

public class QuestionTests {

    @Test
    public void knowHisStatement() {

        Set<ICharacter> characters = new TreeSet<ICharacter>();

        characters.add(new Character("Lucas"));

        Question q = new Question("Est ce que votre personnage est un homme?",characters);

        String enonce = "Est ce que votre personnage est un homme?";

        assertEquals(enonce,q.getStatementOfQuestions());
    }


    @Test
    public void knowHisSetCharacters() {

        Set<ICharacter> characters = new TreeSet<ICharacter>();

        characters.add(new Character("Lucas"));

        Question q = new Question("Est ce que votre personnage est un vieil homme?",characters);


        Set<Character> personages2 = new TreeSet<Character>();

        personages2.add(new Character("Lucas"));

        assertEquals(personages2,q.getSetCharacters());
    }


    @Test
    public void question1EqualsQuestion2() {

        Set<ICharacter> characters = new TreeSet<ICharacter>();

        characters.add(new Character("Lucas"));

        Question q1 = new Question("Est ce que votre personnage est petit?",characters);
        Question q2 = new Question("Est ce que votre personnage est petit?",characters);

        assertTrue(q1.equals(q2));
    }

    @Test
    public void question1NotEqualsQuestion2() {

        Set<ICharacter> characters = new TreeSet<ICharacter>();

        characters.add(new Character("Lucas"));

        Question q1 = new Question("Est ce que votre personnage est petit?",characters);
        Question q2 = new Question("Est ce que votre personnage est grand",characters);

        assertFalse(q1.equals(q2));
    }

    @Test
    public void answerYesTest() {

        Set<ICharacter> characters1 = new TreeSet<ICharacter>();
        characters1.add(new Character("Lucas"));
        characters1.add(new Character("Bernard"));
        characters1.add(new Character("Yann"));
        characters1.add(new Character("Sam"));

        Set<ICharacter>characters2 = new TreeSet<ICharacter>();
        characters2.add(new Character("Lucas"));
        characters2.add(new Character("Sam"));


        IQuestion question = new Question("Ceci est une question",characters1);

        Set<ICharacter> intersection = question.answerYes(characters2);

        assertTrue(intersection.contains(new Character("Lucas")));
        assertFalse(intersection.contains(new Character("Bernard")));
        assertFalse(intersection.contains(new Character("Yann")));
        assertTrue(intersection.contains(new Character("Sam")));

        assertTrue(intersection.contains(new Character("Lucas")));
        assertFalse(intersection.contains(new Character("Bernard")));
        assertFalse(intersection.contains(new Character("Yann")));
        assertTrue(intersection.contains(new Character("Sam")));
    }
    @Test
    public void answerNoTest() {

        Set<ICharacter> characters1 = new TreeSet<>();
        characters1.add(new Character("Lucas"));
        characters1.add(new Character("Bernard"));
        characters1.add(new Character("Yann"));

        Set<ICharacter>characters2 = new TreeSet<>();
        characters2.add(new Character("Lucas"));
        characters2.add(new Character("Sam"));

        IQuestion question = new Question("Ceci est la 2ème question",characters1);

        Set<ICharacter> difference = question.answerNo(characters2);

        assertFalse(difference.contains(new Character("Lucas")));
        assertFalse(difference.contains(new Character("Bernard")));
        assertFalse(difference.contains(new Character("Yann")));
        assertTrue(difference.contains(new Character("Sam")));
    }

    @Test
    public void addCharacterTest() {

        Set<ICharacter> characters1 = new TreeSet<>();
        characters1.add(new Character("Lucas"));
        characters1.add(new Character("Bernard"));
        characters1.add(new Character("Yann"));

        Set<ICharacter>characters2 = new TreeSet<>();
        characters2.add(new Character("Lucas"));
        characters2.add(new Character("Sam"));

        IQuestion question = new Question("Ceci est la 2ème question",characters2);

        question.addCharacter("Yann");

        assertTrue(characters2.contains(new Character("Sam")));
        assertTrue(characters2.contains(new Character("Yann")));
        assertFalse(characters2.contains(new Character("Bernard")));
    }

    @Test
    public void addNullCharacterTest() {

        Set<ICharacter> characters1 = new TreeSet<>();
        characters1.add(new Character("Lucas"));
        characters1.add(new Character("Bernard"));
        characters1.add(new Character("Yann"));

        Set<ICharacter>characters2 = new TreeSet<>();
        characters2.add(new Character("Lucas"));
        characters2.add(new Character("Sam"));

        IQuestion question = new Question("Ceci est la 2ème question",characters2);

        question.addCharacter(null);

        assertTrue(characters2.contains(new Character("Sam")));
        assertFalse(characters2.contains(new Character("Yann")));
        assertFalse(characters2.contains(new Character("Bernard")));
    }
}
