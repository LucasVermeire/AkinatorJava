package model;

public interface IKnowledgeData {
    void addCharacter(String name);
    void exportBank(String path);
    void importBank(String path);
    void restart();
    void answerYes ();
    void answerNo();
    void answerIDK();
}
