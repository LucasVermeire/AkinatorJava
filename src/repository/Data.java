package repository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import models.Question;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.IQuestion;
import models.ICharacter;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.json.*;


public class Data {

    public void exportQuestions(List<IQuestion> bankQuestions, String path) {
        JSONObject jsonObj = new JSONObject();
        JSONArray questionsArray = new JSONArray();
        JSONArray CharactersArray = new JSONArray();

        try{
            for(IQuestion item : bankQuestions) {
                questionsArray.add(item.getStatementOfQuestions());
                CharactersArray.add(item.getSetCharacters());
            }
            jsonObj.put("questions", questionsArray);
            jsonObj.put("Characters", CharactersArray);
        }catch (Exception ex){
            ex.printStackTrace();
        }

        save(path,jsonObj);

        System.out.println("Questions exporté avec succès !");
    }

    public void exportCharacters(Set<ICharacter> characters, String path) {
        JSONObject jsonObj = new JSONObject();
        JSONArray NamesArray = new JSONArray();
        JSONArray DescriptionArray = new JSONArray();

        for(ICharacter item : characters) {
            NamesArray.add(item.getName());
            DescriptionArray.add(item.getDescription());
        }
        jsonObj.put("Name", NamesArray);
        jsonObj.put("Description", DescriptionArray);
        save(path,jsonObj);

        System.out.println("Personnages exporté avec succès !");
    }


    private void save (String path,JSONObject questionObj) {
        try(FileWriter file = new FileWriter(path)){
            file.write(toPrettyFormat(questionObj));
        }catch(IOException ex) {
            ex.printStackTrace();
        }
    }


    private String toPrettyFormat(JSONObject json) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String prettyJson = gson.toJson(json);

        return prettyJson;
    }

    //-----------------------------------------------------------------------------

    public List<IQuestion> importQuestions(String path){
        List<IQuestion> questions = new ArrayList<IQuestion>();

        try(FileReader reader = new FileReader(path)){
            Object obj = new JSONParser().parse(reader);

            JSONObject jo = (JSONObject) obj;

            String firstName = (String) jo.get("questions");

        }catch(Exception ex){
            ex.printStackTrace();
        }

        return questions;
    }


    public Set<ICharacter> importCharacters(String path){
        Set<ICharacter> characters = new TreeSet<ICharacter>();


        return characters;
    }
}
