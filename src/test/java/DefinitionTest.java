import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  @Test
  public void Definition_createNewInstance_true() {
    Definition testDefinition = new Definition("NewInstance");
    assertTrue(testDefinition instanceof Definition);
  }

  @Test
  public void Definition_instantiatesWithWordMeaning_String() {
    Definition testDefinition = new Definition("make a beverage by soaking, boiling, and fermentation");
    assertEquals("make a beverage by soaking, boiling, and fermentation", testDefinition.getWordMeaning());
  }
}
