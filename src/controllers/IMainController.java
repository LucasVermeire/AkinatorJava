package controllers;

public interface IMainController {
    void switchView(String fileFXML);
    void exit();
    void notifyQuestion();
    void answerYes();
    void answerNo();
    void answerIDK();
    String getQuestion();
}
