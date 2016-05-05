import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.fluentlenium.core.filter.FilterConstructor.*;


import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Construct Your Own Dictionary!");
    assertThat(pageSource()).contains("View Word List");
    assertThat(pageSource()).contains("Add a New Word");
  }

  @Test
  public void wordIsCreatedTest() {
    goTo("http://localhost:4567/");
    click("a", withText("Add a New Word"));
    fill("#name").with("Brew");
    submit(".btn");
    assertThat(pageSource()).contains("has been saved");
  }

  @Test
  public void wordIsDisplayedTest() {
    goTo("http://localhost:4567/words/new");
    fill("#name").with("Brew");
    submit(".btn");
    click("a", withText("View words"));
    assertThat(pageSource()).contains("Brew");
  }

  @Test
  public void wordShowPageDisplaysName() {
    goTo("http://localhost:4567/words/new");
    fill("#name").with("Brew");
    submit(".btn");
    click("a", withText("View words"));
    click("li", withText("Brew"));
    assertThat(pageSource()).contains("Brew");
  }

  @Test
  public void wordDefinitionsFormIsDisplayed() {
    goTo("http://localhost:4567/words/new");
    fill("#name").with("Brew");
    submit(".btn");
    click("a", withText("Add definition"));
    assertThat(pageSource()).contains("Add a definition to Brew");
  }

  @Test
  public void definitionsIsAddedAndDisplayed() {
    goTo("http://localhost:4567/words/new");
    fill("#name").with("Cat");
    submit(".btn");
    click("a", withText("Add definition"));
    fill("#wordMeaning").with("el gato");
    submit(".btn");
    click("a", withText("View words"));
    click("a", withText("Cat"));
    //gave "org.openqa.selenium.StaleElementReferenceException at AppTest.java:76" because i put click on 'a'. should be 'li'? Too many instances of "Brew?"
    assertThat(pageSource()).contains("el gato");
  }
}
