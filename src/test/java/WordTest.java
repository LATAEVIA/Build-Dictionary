import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {
  @After
  public void tearDown() {
    Word.clear();
    Definition.clear();
  }

  @Test
    public void word_instantiatesCorrectly_true() {
    Word testWord = new Word("Brew");
    assertEquals(true, testWord instanceof Word);
  }

  @Test
  public void getName_wordInstantiatesWithName_Brew() {
    Word testWord = new Word("Brew");
    assertEquals("Brew", testWord.getName());
  }

  @Test
  public void all_returnsAllInstancesOfWord_true() {
    Word firstWord = new Word("Brew");
    Word secondWord = new Word("Dress");
    assertTrue(Word.all().contains(firstWord));
    assertTrue(Word.all().contains(secondWord));
  }

  @Test
  public void clear_emptiesAllWordsFromList_0() {
    Word testWord = new Word("Brew");
    Word.clear();
    assertEquals(0, Word.all().size());
  }

  @Test
  public void getId_wordsInstantiateWithAnId_1() {
    Word testWord = new Word("Brew");
    assertEquals(1, testWord.getId());
  }

  @Test
  public void find_returnsWordWithSameId_secondWord() {
    Word firstWord = new Word("Brew");
    Word secondWord = new Word("Dress");
    assertEquals(Word.find(secondWord.getId()), secondWord);
  }

  @Test
  public void getDefinitions_initiallyReturnsEmptyList_ArrayList() {
    Word testWord = new Word("Brew");
    assertEquals(0, testWord.getDefinitions().size());
  }

  @Test
  public void addDefinitions_addsDefinitionToList_true() {
    Word testWord = new Word("Brew");
    Definition testDefinition = new Definition("make a beverage by soaking, boiling, and fermentation");
    testWord.addDefinition(testDefinition);
    assertTrue(testWord.getDefinitions().contains(testDefinition));
  }
}
