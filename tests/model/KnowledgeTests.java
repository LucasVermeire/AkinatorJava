package model;


import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

class KnowledgeTests {

	@Test
	public void knowQuestionString() {
		Knowledge knowledge = new Knowledge();

		assertEquals("Est ce que votre personnage est un homme ?",knowledge.getQuestion());
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
		int size = 8;

		Knowledge knowledge = new Knowledge();

		assertEquals(size,knowledge.knowNumberOfQuestions());
	}

	@Test
	public void knowIndex() {
		int index = 0;

		Knowledge knowledge = new Knowledge();

		assertEquals(index,knowledge.getIndex());
	}
}
