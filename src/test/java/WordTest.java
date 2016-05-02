import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {

  @Test
  public void Word_createNewInstance_true() {
    Word testWord = new Word("NewInstance");
    assertTrue(testWord instanceof Word);
  }
}
