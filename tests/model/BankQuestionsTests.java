package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import repository.Repository;

class BankQuestionsTests {

    @Test
    public void knowHisListQuestions() {

        Knowledge knowledge = new Knowledge();

        BankQuestions bankQuestions = new BankQuestions();

        Set<ICharacter> characters1 = new HashSet<>();
        characters1.add(new Character("Chewbacca"));
        characters1.add(new Character("Hans Solo"));
        characters1.add(new Character("Luke Skywalker"));
        characters1.add(new Character("R2 D2"));
        characters1.add(new Character("Yoda"));
        characters1.add(new Character("C3PO"));
        characters1.add(new Character("Finn"));
        characters1.add(new Character("Rey"));

        bankQuestions.addQuestion("Votre personnage est-il du côté de la force ?",characters1);

        Set<ICharacter> characters2 = new HashSet<>();
        characters2.add(new Character("Chewbacca"));
        characters2.add(new Character("Yoda"));

        bankQuestions.addQuestion("Votre personnage est-il une créature ?",characters2);

        Set<ICharacter> characters3 = new HashSet<>();
        characters3.add(new Character("Dark Vador"));
        characters3.add(new Character("Hans Solo"));

        bankQuestions.addQuestion("Est ce que votre personnage a été assasiné par son propre fils ?",characters3);


        Set<ICharacter> characters4 = new HashSet<>();
        characters4.add(new Character("Luke Skywalker"));
        characters4.add(new Character("Kylo Ren"));
        characters4.add(new Character("R2 D2"));
        characters4.add(new Character("Yoda"));


        bankQuestions.addQuestion("Votre personnage a-t-il disparu des années ?",characters4);


        Set<ICharacter> characters5 = new HashSet<>();
        characters5.add(new Character("R2 D2"));
        characters5.add(new Character("C3PO"));

        bankQuestions.addQuestion("Est ce que votre personnage est un robot ?",characters5);

        Set<ICharacter> characters6 = new HashSet<>();
        characters6.add(new Character("Chewbacca"));

        bankQuestions.addQuestion("Accompagne t-il Hans Solo pendant ses aventures ?",characters6);

        Set<ICharacter> characters7 = new HashSet<>();
        characters7.add(new Character("Rey"));

        bankQuestions.addQuestion("Est-il une femme ?",characters7);

        assertEquals(knowledge.getBankQuestion().getBankQuestions(),bankQuestions.getBankQuestions());
    }

    @Test
    public void knowQuestionByIndex(){

        Knowledge knowledge = new Knowledge();

        BankQuestions bankQuestions = knowledge.getBankQuestion();

        IQuestion question = bankQuestions.getQuestionByIndex(0);

        Set<ICharacter> characters1 = new HashSet<>();

        characters1.add(new Character("Chewbacca"));
        characters1.add(new Character("Hans Solo"));
        characters1.add(new Character("Luke Skywalker"));
        characters1.add(new Character("R2 D2"));
        characters1.add(new Character("Yoda"));
        characters1.add(new Character("C3PO"));
        characters1.add(new Character("Finn"));
        characters1.add(new Character("Rey"));


        assertEquals(new Question("Votre personnage est-il du côté de la force ?",characters1),question);
    }

    @Test
    public void knowQuestionByIndexOversize(){

        BankQuestions bankQuestions = new BankQuestions();

        IQuestion question = bankQuestions.getQuestionByIndex(134);

        assertNull(question);
    }

    @Test
    public void knowQuestionByIndexNegated(){

        BankQuestions bankQuestions = new BankQuestions();

        IQuestion question = bankQuestions.getQuestionByIndex(-12);

        assertNull(question);
    }

    @Test
    public void knowQuestionToString(){

        Knowledge knowledge = new Knowledge();

        BankQuestions bankQuestions = knowledge.getBankQuestion();

        String statement = "Votre personnage est-il du côté de la force ?";

        assertEquals(statement,bankQuestions.questionToString(0));
    }

    @Test
    public void knowQuestionToStringIndexOversize(){
        Knowledge knowledge = new Knowledge();

        BankQuestions bankQuestions = knowledge.getBankQuestion();

        assertEquals(" ",bankQuestions.questionToString(135));
    }

    @Test
    public void knowQuestionToStringIndexNegated(){
        Knowledge knowledge = new Knowledge();

        BankQuestions bankQuestions = knowledge.getBankQuestion();

        assertEquals(" ",bankQuestions.questionToString(-2));
    }

    @Test
    public void addCharacterOneTrue(){
        Knowledge knowledge = new Knowledge();

        BankQuestions bankQuestions = knowledge.getBankQuestion();

        List<String> pastQuestions = new ArrayList<>();
        pastQuestions.add("true");
        pastQuestions.add("false");
        pastQuestions.add("none");
        bankQuestions.addCharacterInQuestion("Lucas Vermeire",pastQuestions);

        IQuestion question = bankQuestions.getQuestionByIndex(0);

        Set<ICharacter> characters1 = question.getSetCharacters();

        Set<ICharacter> characters2 = new HashSet<>();
        characters2.add(new Character("Chewbacca"));
        characters2.add(new Character("Hans Solo"));
        characters2.add(new Character("Luke Skywalker"));
        characters2.add(new Character("R2 D2"));
        characters2.add(new Character("Yoda"));
        characters2.add(new Character("C3PO"));
        characters2.add(new Character("Finn"));
        characters2.add(new Character("Rey"));
        characters2.add(new Character("Lucas Vermeire"));

        assertEquals(characters2,characters1);
    }

    @Test
    public void addCharacterTwoTrue(){
        Knowledge knowledge = new Knowledge();

        BankQuestions bankQuestions = knowledge.getBankQuestion();

        List<String> pastQuestions = new ArrayList<>();
        pastQuestions.add("true");
        pastQuestions.add("true");
        pastQuestions.add("none");
        bankQuestions.addCharacterInQuestion("Lucas Vermeire",pastQuestions);

        IQuestion question = bankQuestions.getQuestionByIndex(0);

        Set<ICharacter> characters1 = question.getSetCharacters();

        Set<ICharacter> characters2 = new HashSet<>();
        characters2.add(new Character("Chewbacca"));
        characters2.add(new Character("Hans Solo"));
        characters2.add(new Character("Luke Skywalker"));
        characters2.add(new Character("R2 D2"));
        characters2.add(new Character("Yoda"));
        characters2.add(new Character("C3PO"));
        characters2.add(new Character("Finn"));
        characters2.add(new Character("Rey"));
        characters2.add(new Character("Lucas Vermeire"));

        IQuestion question2 = bankQuestions.getQuestionByIndex(1);
        Set<ICharacter> characters3 = question2.getSetCharacters();

        Set<ICharacter> characters4 = new HashSet<>();
        characters4.add(new Character("Chewbacca"));
        characters4.add(new Character("Yoda"));
        characters4.add(new Character("Lucas Vermeire"));

        assertEquals(characters2,characters1);
        assertEquals(characters4,characters3);
    }
}
