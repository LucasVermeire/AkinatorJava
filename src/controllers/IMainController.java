package controllers;

/**
 *
 */
public interface IMainController {
    String getQuestion();
    String getPathImg();
    String getSolution();

    void switchView(String fileFXML);
    void exit();

    void answerYes();
    void answerNo();
    void answerIDK();

    void notifyQuestion();
    void notifySolution();
}
