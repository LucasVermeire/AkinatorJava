package repository;

import models.IQuestion;
import models.ICharacter;
import models.Character;
import models.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataTests {

    @BeforeEach
    public void exportQuestion(){
        Data data = new Data();

        Set<ICharacter> characters = new TreeSet<ICharacter>();
        Character c = new Character("Lucas");
        characters.add(c);

        Question q = new Question("Est ce que votre personnage est un homme ? ", characters);
        Question q2 = new Question("Est ce que votre personnage est une femme ? ", characters);

        List<IQuestion> questions = new ArrayList<IQuestion>();
        questions.add(q);
        questions.add(q2);

        data.exportQuestions(questions,"rsc/questions.json");
    }

    /*
    @BeforeEach
    public void exportCharacters(){
        Data data = new Data();

        Set<ICharacter> characters = new TreeSet<ICharacter>();

        Character character = new Character("Lucas");
        Character character2 = new Character("Sam");

        characters.add(character);
        characters.add(character2);

        data.exportCharacters(characters,"rsc/personnages.json");
    }*/

    @Test
    public void exportJsonQuestion(){
        String path = "rsc/questions.json";
        File f = new File (path);

        assertTrue(f.exists() && !f.isDirectory());
    }

    @Test
    public void importQuestion(){
        Data data = new Data();

        data.importCharacters("rsc/questions.json");
    }

/*
    @Test
    public void exportJsonCharacters(){
        String path = "rsc/personnages.json";
        File f = new File (path);

        assertTrue(f.exists() && !f.isDirectory());
    }*/


/*
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
    }*/
}
