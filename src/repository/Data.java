package repository;

import java.io.*;
import java.util.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import model.Character;
import model.Question;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.IQuestion;
import model.ICharacter;


public class Data {

    /**
     *
     * @param questions
     * @param path
     */
    public void exportBank(List<IQuestion> questions,IQuestion question, String path) {
        JSONObject obj = new JSONObject();
        JSONArray array = new JSONArray();

        for(IQuestion item : questions ){
            JSONObject obj2 = new JSONObject();
            obj2.put("statement",item.getStatementOfQuestions());
            JSONArray array2 = getCharacters(question.getSetCharacters());
            obj2.put("character",array2);
            array.add(obj2);
        }

        obj.put("questions",array);

        save(path,obj);
    }

    private JSONArray getCharacters(Set<ICharacter> characters){

        JSONArray array2 = new JSONArray();

        for(ICharacter item : characters){
            array2.add(item.getName());
        }
        return array2;
    }


    /**
     *
     * @param path
     * @param questionObj
     */
    private void save (String path,JSONObject questionObj) {
        String desktopPath = System.getProperty("user.home") + "\\OneDrive\\Bureau";
        try(FileWriter file = new FileWriter(new File(desktopPath,path))){
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

    //#################################################

    /**
     *
     * @param path
     * @return
     */
    public List<IQuestion> importQuestions(String path){
        List<IQuestion> questions = new ArrayList<IQuestion>();

        try (InputStream reader = new FileInputStream(path)) {
            JsonReader jsonReader = Json.createReader(reader);
            JsonObject readObject = jsonReader.readObject();

            questionsToList(readObject,questions);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return questions;
    }

    /**
     *
     * @param jsonObject
     * @param questions
     */
    private void questionsToList(JsonObject jsonObject, List<IQuestion> questions) {
        JsonArray arrayQuestions = jsonObject.getJsonArray("questions");

        for (JsonValue item : arrayQuestions) {
            JsonObject object = (JsonObject) item;

            Set<ICharacter> characterSet = new HashSet<ICharacter>();

            setArrayCharacters(object,characterSet);

            questions.add(new Question(object.getString("statement"), characterSet));
        }
    }

    /**
     *
     * @param object
     * @param characterSet
     */
    private void setArrayCharacters (JsonObject object, Set<ICharacter> characterSet ){
        JsonArray arrayCharacters = object.getJsonArray("characters");

        for (JsonValue jsonValue : arrayCharacters) {
            characterSet.add(new Character(jsonValue.toString().replace("\"", "")));
        }
    }

    public Set<ICharacter> importCharacters(String path){
        Set<ICharacter> characters = new HashSet<ICharacter>();

        try (InputStream reader = new FileInputStream(path)) {
            JsonReader jsonReader = Json.createReader(reader);
            JsonObject readObject = jsonReader.readObject();

            characterToList(readObject,characters);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }

    private void characterToList(JsonObject jsonObject, Set<ICharacter> characters) {
        JsonArray arrayCharacters = jsonObject.getJsonArray("characters");

        for (JsonValue item : arrayCharacters) {
            JsonObject object = (JsonObject) item;

            JsonArray arrayCharacters2 = object.getJsonArray("listCharacters");

            for (JsonValue jsonValue : arrayCharacters2) {
                characters.add(new Character(jsonValue.toString().replace("\"", "")));
            }
        }
    }
}
