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

    /**
     * <p>La méthodevoid exportQuestions(Set<Question> bankQuestions, String path) permet d'exporter l'ensemble des questions dans un fichier JSON</p>
     * @param bankQuestions
     * @param path
     */

    public void exportQuestions(List<IQuestion> bankQuestions,String path) {
        JSONObject jsonObj = new JSONObject();
        JSONArray questionsArray = new JSONArray();

        for(IQuestion q : bankQuestions) {
            JSONArray array = new JSONArray();
            array.add(q.getStatementOfQuestions());
            questionsArray.add(array);
        }

        jsonObj.put("questions", questionsArray);
        save(questionsArray,path+"questions.json",jsonObj);
    }

    /**
     * <p>La méthode void exportPersonnage(Set<Personnage> bankPersonnages, String path) permet d'exporter l'ensemble des personnages dans un fichier JSON</p>
     * @param bankPersonnages
     * @param path
     */
    public void exportPersonnage(Set<ITheme> bankPersonnages,String path) {
        JSONObject jsonObj = new JSONObject();
        JSONArray questionsArray = new JSONArray();

        for(ITheme item : bankPersonnages) {
            JSONArray array = new JSONArray();
            array.add(item.getName());
            array.add(item.getDescription());
            questionsArray.add(array);
        }

        jsonObj.put("personnages", questionsArray);
        save(questionsArray,path+"personnages.json",jsonObj);
    }


    private void save (JSONArray questionList, String path,JSONObject questionObj) {
        try(FileWriter file = new FileWriter(path)){
            file.write(toPrettyFormat(questionList.toJSONString(),questionObj));
        }catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * <p>La méthode toPrettyFormat(String jsonString,JSONObject json) permet d'afficher plus clairement les questions dans le fichier JSON</p>
     * @param jsonString
     * @param json
     * @return String prettyJson
     */
    private String toPrettyFormat(String jsonString,JSONObject json) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String prettyJson = gson.toJson(json);

        return prettyJson;
    }


    /**
     * <p>La méthode importquestion (Set<Question>questions,String path) permet d'importer d'un fichier JSON les questions</p>
     * @param questions
     * @param path
     */
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


    /**
     * <p>La méthode importPersonnages (Set<Personnage>personnages,String path) permet d'importer d'un fichier JSON les personnages</p>
     * @param personnages
     * @param path
     */
    public void importPersonnages(Set<ITheme>personnages,String path){
        personnages = new TreeSet<ITheme>();

        try(BufferedReader input = Files.newBufferedReader(Paths.get(path))){
            //TODO

        }catch(IOException ex) {
            System.out.println("Not found");
        }
    }
}
