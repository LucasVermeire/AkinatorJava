package repository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import interfaces.IQuestion;
import interfaces.ITheme;


@SuppressWarnings("unchecked")
public class Data {


    public void exportQuestions(List<IQuestion> bankQuestions,String path) {
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


    public void importQuestion(List<IQuestion>questions,String path){
        questions = new ArrayList<IQuestion>();

        String messageErreur = "Not found";


        try(FileReader reader = new FileReader(path)){

            //TODO

        }catch(FileNotFoundException ex) {
            System.out.println(messageErreur);
        }catch(IOException ex) {
            System.out.println(messageErreur);
        }
    }


    public void importPersonnages(Set<ITheme>personnages,String path){
        personnages = new TreeSet<ITheme>();

        try(BufferedReader input = Files.newBufferedReader(Paths.get(path))){
            //TODO

        }catch(IOException ex) {
            System.out.println("Not found");
        }
    }
}
