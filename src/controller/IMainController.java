package controller;

import model.BankCharacters;

public interface IMainController {
    String getQuestion();
    String getPathImg();
    String getSolution();
    BankCharacters getCharacters();
    String[] getListCharacters();

    void switchView(String fileFXML);
    void exit();

    void answerYes();
    void answerNo();
    void answerIDK();

    void notifyQuestion();
    void notifySolution();

    void addCharacter(String name);
    void exportBank(String path);
    void importBank(String path);
    void restart();
}
