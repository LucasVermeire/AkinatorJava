package model;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class KnowledgeTests {

	@Test
	public void knowQuestionString() {
		Knowledge knowledge = new Knowledge();

		assertEquals("Votre personnage est-il du côté de la force ?",knowledge.getQuestion());
	}

	@Test
	public void knowSetFinal() {
		Knowledge knowledge = new Knowledge();

		assertEquals(new HashSet<>(),new HashSet<>(knowledge.getSetFinal()));
	}

	@Test
	public void knowImgLastCharacter() {
		Knowledge knowledge = new Knowledge();

		assertEquals(".jpg",knowledge.getImgLastCharacter());
	}

	@Test
	public void knowLastCharacter(){
		Knowledge knowledge = new Knowledge();

		assertEquals(new Character(""),knowledge.getLastCharacter());
	}

	@Test
	public void knowNumberOfQuestions() {
		int size = 7;

		Knowledge knowledge = new Knowledge();

		assertEquals(size,knowledge.knowNumberOfQuestions());
	}

	@Test
	public void knowIndex() {
		int index = 1;

		Knowledge knowledge = new Knowledge();

		knowledge.answerIDK();

		assertEquals(index,knowledge.getIndex());
	}

	@Test
	public void answerYes(){
		BankCharacters bankCharacters = new BankCharacters();

		Knowledge knowledge = new Knowledge();

		Set<ICharacter> setFinal = bankCharacters.getBankCharacters();

		knowledge.answerYes();

		Set<ICharacter> characterSet = bankCharacters.getBankCharacters();

		assertEquals(characterSet,setFinal);
	}

	@Test
	public void answerNo(){
		BankCharacters bankCharacters = new BankCharacters();

		Knowledge knowledge = new Knowledge();

		Set<ICharacter> setFinal = bankCharacters.getBankCharacters();

		knowledge.answerNo();

		Set<ICharacter> characterSet = bankCharacters.getBankCharacters();

		assertEquals(characterSet,setFinal);
	}

	@Test
	public void answerIDK(){
		BankCharacters bankCharacters = new BankCharacters();

		Knowledge knowledge = new Knowledge();

		Set<ICharacter> setFinal = bankCharacters.getBankCharacters();

		knowledge.answerIDK();

		Set<ICharacter> characterSet = bankCharacters.getBankCharacters();

		assertEquals(characterSet,setFinal);
	}

	@Test
	public void exportBank() {
		try{
			String path = "bank.json";

			File f = new File (path);
			f.createNewFile();

			Knowledge knowledge = new Knowledge();

			knowledge.exportBank(path);

			assertTrue(f.exists() && !f.isDirectory());

		}catch (Exception ex){
			ex.printStackTrace();
		}
	}

	@Test
	public void restart(){
		BankCharacters bankCharacters = new BankCharacters();

		Knowledge knowledge = new Knowledge();

		Set<ICharacter> setFinal = bankCharacters.getBankCharacters();

		knowledge.restart();

		Set<ICharacter> characterSet = bankCharacters.getBankCharacters();

		assertEquals(characterSet,setFinal);
	}

	@Test
	public void importBank() {
		try{
			String path = "rsc//bank.json";

			Knowledge knowledge = new Knowledge();

			knowledge.importBank(path);

		}catch (Exception ex){
			ex.printStackTrace();
		}
	}

	@Test
	public void addCharacter(){
		Knowledge knowledge = new Knowledge();




	}
}
