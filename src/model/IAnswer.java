package model;

public interface IAnswer {

    /**
     * This method uses a method in the IQuestion interface that returns a set of characters
     * whose answer to the question is YES
     * @param index int
     */
    void answerYes (int index);

    /**
     * This method uses a method in the IQuestion interface that returns a set of characters
     * whose answer to the question is NO
     * @param index
     */
    void answerNo (int index);

    void answerIDK(int index);
}
