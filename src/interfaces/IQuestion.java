package interfaces;

import java.util.Set;

public interface IQuestion {
    Set<ITheme> answerNo (Set<ITheme> p);
    Set<ITheme> answerYes (Set<ITheme> p);
    String getStatementOfQuestions();
}
