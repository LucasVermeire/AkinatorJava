package repository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import interfaces.IQuestion;
import interfaces.ITheme;


@SuppressWarnings("unchecked")
public class Data {

    public void exportQuestions(List<IQuestion> bankQuestions, String path) {
        JSONObject jsonObj = new JSONObject();
        JSONArray questionsArray = new JSONArray();

        for(IQuestion q : bankQuestions) {
            JSONArray array = new JSONArray();
            array.add(q.getStatementOfQuestions());
            array.add(q.getSetCharacters());
            questionsArray.add(array);
        }

        jsonObj.put("questions", questionsArray);
        save(questionsArray,path,jsonObj);

        System.out.println("Questions exporté avec succès !");
    }

    public void exportCharacters(Set<ITheme> characters, String path) {
        JSONObject jsonObj = new JSONObject();
        JSONArray questionsArray = new JSONArray();

        for(ITheme item : characters) {
            JSONArray array = new JSONArray();
            array.add(item.getName());
            array.add(item.getDescription());
            questionsArray.add(array);
        }

        jsonObj.put("personnages", questionsArray);
        save(questionsArray,path,jsonObj);

        System.out.println("Personnages exporté avec succès !");
    }


    private void save (JSONArray questionList, String path,JSONObject questionObj) {
        try(FileWriter file = new FileWriter(path)){
            file.write(toPrettyFormat(questionList.toJSONString(),questionObj));
        }catch(IOException ex) {
            ex.printStackTrace();
        }
    }


    private String toPrettyFormat(String jsonString,JSONObject json) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String prettyJson = gson.toJson(json);

        return prettyJson;
    }

    //-----------------------------------------------------------------------------

    public void importQuestions(List<IQuestion>questions, String path){
        try (FileReader reader = new FileReader(path)) {
            //TODO

        } catch (IOException e) {
            System.out.println("Fichier non trouv");
        }

    }


    public void importCharacters(Set<ITheme>characters, String path){
        try(BufferedReader input = Files.newBufferedReader(Paths.get(path))){
            //TODO

        }catch(IOException ex) {
            System.out.println("Not found");
        }
    }
}
