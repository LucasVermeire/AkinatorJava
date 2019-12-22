package model;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class AnswerTests {

    @Test
    public void answerYesToTheFirstQuestion(){
        BankCharacters bankCharacters = new BankCharacters();

        Knowledge knowledge = new Knowledge();

        Set<ICharacter> setFinal = bankCharacters.getBankCharacters();

        List<String> pastQuestions = knowledge.getPastQuestions();

        Answer answer = new Answer(setFinal,knowledge.getBankQuestion(),pastQuestions);

        answer.answerYes(0);

        Set<ICharacter> characterSet = bankCharacters.getBankCharacters();

        assertEquals(characterSet,setFinal);
    }

    @Test
    public void answerNoToTheFirstQuestion(){
        BankCharacters bankCharacters = new BankCharacters();
        Knowledge knowledge = new Knowledge();

        Set<ICharacter> setFinal = bankCharacters.getBankCharacters();

        List<String> pastQuestions = knowledge.getPastQuestions();

        Answer answer = new Answer(setFinal,knowledge.getBankQuestion(),pastQuestions);

        answer.answerNo(0);

        Set<ICharacter> characterSet = bankCharacters.getBankCharacters();

        assertEquals(characterSet,setFinal);
    }

    @Test
    public void answerIDKToTheFirstQuestion(){
        BankCharacters bankCharacters = new BankCharacters();
        Knowledge knowledge = new Knowledge();

        Set<ICharacter> setFinal = bankCharacters.getBankCharacters();

        List<String> pastQuestions = knowledge.getPastQuestions();

        Answer answer = new Answer(setFinal,knowledge.getBankQuestion(),pastQuestions);

        answer.answerIDK(0);

        Set<ICharacter> characterSet = bankCharacters.getBankCharacters();

        assertEquals(characterSet,setFinal);
    }
}
