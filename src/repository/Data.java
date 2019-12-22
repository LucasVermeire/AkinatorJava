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

    public void exportBank(List<IQuestion> questions,Set<ICharacter>characters, String path) {
        JSONObject obj = new JSONObject();
        JSONArray arrayQuestions = new JSONArray();

        for(IQuestion item : questions ){
            JSONObject obj2 = new JSONObject();
            obj2.put("statement",item.getStatementOfQuestions());
            JSONArray array2 = new JSONArray();
            for(ICharacter item2 : item.getSetCharacters()){
                array2.add(item2.getName());
            }
            obj2.put("character",array2);
            arrayQuestions.add(obj2);
        }

        JSONArray arrayCharacter = new JSONArray();

        for(ICharacter item : characters){
            arrayCharacter.add(item.getName());
        }

        obj.put("questions",arrayQuestions);
        obj.put("characters",arrayCharacter);

        save(path,obj);
    }

    private void save (String path,JSONObject questionObj) {
        try(FileWriter file = new FileWriter(new File(path))){
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

    public void importBank(String path, List<IQuestion> questions, Set<ICharacter> characters){

        try (InputStream reader = new FileInputStream(path)) {
            JsonReader jsonReader = Json.createReader(reader);
            JsonObject readObject = jsonReader.readObject();

            questionsToList(readObject,questions);
            characterToList(readObject,characters);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void questionsToList(JsonObject jsonObject, List<IQuestion> questions) {
        JsonArray arrayQuestions = jsonObject.getJsonArray("questions");

        for (JsonValue item : arrayQuestions) {
            JsonObject object = (JsonObject) item;

            Set<ICharacter> characterSet = new HashSet<ICharacter>();

            setArrayCharacters(object,characterSet);

            questions.add(new Question(object.getString("statement"), characterSet));
        }
    }

    private void setArrayCharacters (JsonObject object, Set<ICharacter> characterSet ){
        JsonArray arrayCharacters = object.getJsonArray("characters");

        for (JsonValue jsonValue : arrayCharacters) {
            characterSet.add(new Character(jsonValue.toString().replace("\"", "")));
        }
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
