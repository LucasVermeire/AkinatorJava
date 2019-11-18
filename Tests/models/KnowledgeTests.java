package models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.*;
import org.junit.jupiter.api.Test;
import interfaces.IQuestion;
import interfaces.ITheme;
import models.Knowledge;
import models.Character;
import models.Question;

class KnowledgeTests {

    @Test
    public void knowHisBankCharacters() {
        Set<ITheme> characters = new TreeSet<ITheme>();
        characters.add(new Character("Lucas","Etudiant 1"));

        Knowledge bank = new Knowledge();

        Set<ITheme> newCharacters = new HashSet<ITheme>();
        newCharacters.add(new Character("Lucas","Etudiant 1"));

        assertEquals(newCharacters, new HashSet<ITheme>(bank.getBankCharacters()));
        //TODO
    }

    @Test
    public void knowHisBankQuestions() {
        Set<ITheme> characters = new TreeSet<ITheme>();
        characters.add(new Character("Lucas","Etudiant 1"));

        List<IQuestion> questions = new ArrayList<IQuestion>();
        Question q = new Question("Est ce un homme ?",characters);
        questions.add(q);

        Knowledge k = new Knowledge();

        Set<IQuestion> newQuestions = new HashSet<IQuestion>();
        newQuestions.add(q);

        assertEquals(newQuestions, new HashSet<IQuestion>(k.getBankQuestions()));
    }

//	@Test
//	public void knowAnswerTrue() {
//
//	}
//
//	@Test
//	public void knowAnswerFalse() {
//
//	}
//
//	@Test
//	public void knowSetFinal() {
//
//	}
}
