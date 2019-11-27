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

    /**
     *
     * @param bankQuestions
     * @param path
     */
    public void exportQuestions(List<IQuestion> bankQuestions, String path) {

    }

    /**
     *
     * @param characters
     * @param path
     */
    public void exportCharacters(Set<ICharacter> characters, String path) {


    }

    /**
     *
     * @param path
     * @param questionObj
     */
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

            jsonReader.close();
            reader.close();

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

            Set<ICharacter> characterSet = new TreeSet<ICharacter>();

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

    /**
     *
     * @param path
     * @return
     */
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
