package repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import models.Character;
import models.Question;
import org.json.simple.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.IQuestion;
import models.ICharacter;


public class Data {

    public void exportQuestions(List<IQuestion> bankQuestions, String path) {
        /*JSONObject jsonObj = new JSONObject();
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

        System.out.println("Questions exporté avec succès !");*/
    }

    public void exportCharacters(Set<ICharacter> characters, String path) {
        /*JSONObject jsonObj = new JSONObject();
        JSONArray NamesArray = new JSONArray();
        JSONArray DescriptionArray = new JSONArray();

        for(ICharacter item : characters) {
            NamesArray.add(item.getName());
        }
        jsonObj.put("Name", NamesArray);
        jsonObj.put("Description", DescriptionArray);
        save(path,jsonObj);

        System.out.println("Personnages exporté avec succès !");*/
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

        try (InputStream reader = new FileInputStream(path)) {
            JsonReader rdr = Json.createReader(reader);
            JsonObject jsonObj = rdr.readObject();

            rdr.close();
            reader.close();

            questionsToList(jsonObj,questions);

        } catch (IOException e) {
            System.out.println("Fichier non trouvé");
        }
        return questions;
    }

    private void questionsToList(JsonObject jsonObj, List<IQuestion> questions) {
        JsonArray arrayQuestion = jsonObj.getJsonArray("questions");
        for (JsonValue value : arrayQuestion) {
            JsonObject obj = (JsonObject) value;

            JsonArray charactersArray = obj.getJsonArray("characters");
            Set<ICharacter> characterSet = new TreeSet<ICharacter>();

            for (JsonValue jsonValue : charactersArray) {
                characterSet.add(new Character(jsonValue.toString().replace("\"", "")));
            }
            questions.add(new Question(obj.getString("statement"), characterSet));
        }
    }

    public Set<ICharacter> importCharacters(String path){
        Set<ICharacter> characters = new TreeSet<ICharacter>();

        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();
            String [] charactersToList = line.split(";");

            for(String item : charactersToList){
                characters.add(new Character(item));
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }

        return characters;
    }
}
