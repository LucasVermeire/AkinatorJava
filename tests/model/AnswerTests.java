package model;

import org.junit.jupiter.api.Test;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class AnswerTests {

    @Test
    public void answerYesToTheFirstQuestion(){
        BankCharacters bankCharacters = new BankCharacters();

        Set<ICharacter> setFinal = bankCharacters.getBankCharacters();

        Answer answer = new Answer(setFinal);

        answer.answerYes(0);

        Set<ICharacter> characterSet = bankCharacters.getBankCharacters();

        assertEquals(characterSet,setFinal);
    }

    @Test
    public void answerNoToTheFirstQuestion(){
        BankCharacters bankCharacters = new BankCharacters();

        Set<ICharacter> setFinal = bankCharacters.getBankCharacters();

        Answer answer = new Answer(setFinal);

        answer.answerNo(0);

        Set<ICharacter> characterSet = bankCharacters.getBankCharacters();

        assertEquals(characterSet,setFinal);
    }
}
