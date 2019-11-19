package repository;

import interfaces.IQuestion;
import interfaces.ITheme;
import models.BankCharacters;
import models.Character;
import models.Question;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

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

    }

    @Test
    public void exportJsonCharacters(){

    }


}
