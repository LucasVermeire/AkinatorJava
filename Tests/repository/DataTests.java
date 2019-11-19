package repository;

import interfaces.IQuestion;
import interfaces.ITheme;
import models.Character;
import models.Question;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataTests {

    @BeforeEach
    public void exportQuestion(){
        Data data = new Data();

        Set<ITheme> characters = new TreeSet<ITheme>();
        Character c = new Character("Lucas","Etudiant");
        characters.add(c);

        Question q = new Question("Est ce que votre personnage est un homme ? ", characters);

        List<IQuestion> questions = new ArrayList<IQuestion>();
        questions.add(q);

        data.exportQuestions(questions,"rsc/questionsTests.json");
    }

    @BeforeEach
    public void exportCharacters(){
        Data data = new Data();

        Set<ITheme> characters = new TreeSet<ITheme>();

        Character character = new Character("Lucas","Etudiant");

        characters.add(character);

        data.exportCharacters(characters,"rsc/personnagesTests.json");
    }

    @Test
    public void exportJsonQuestion(){
        String path = "rsc/questionsTests.json";
        File f = new File (path);

        assertTrue(f.exists() && !f.isDirectory());
    }

    @Test
    public void exportJsonCharacters(){
        String path = "rsc/personnagesTests.json";
        File f = new File (path);

        assertTrue(f.exists() && !f.isDirectory());
    }

    @AfterEach
    public void deleteFileQuestions(){
        String pathQuestions = "rsc/questionsTests.json";
        String pathCharacters = "rsc/personnagesTests.json";
        File f1 = new File(pathQuestions);
        File f2 = new File(pathCharacters);

        if(f1.delete() && f2.delete()){
            System.out.println("Fichier de test supprimé avec succès !");
        }else{
            System.out.println("Suppression a échoué !" );
        }
    }
}
