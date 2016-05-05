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
    fill("#name").with("Household chores");
    submit(".btn");
    assertThat(pageSource()).contains("has been saved");
  }

  @Test
  public void wordIsDisplayedTest() {
    goTo("http://localhost:4567/words/new");
    fill("#name").with("Household chores");
    submit(".btn");
    click("a", withText("View words"));
    assertThat(pageSource()).contains("Household chores");
  }

  @Test
  public void wordShowPageDisplaysName() {
    goTo("http://localhost:4567/words/new");
    fill("#name").with("Household chores");
    submit(".btn");
    click("a", withText("View words"));
    click("a", withText("Household chores"));
    assertThat(pageSource()).contains("Household chores");
  }

  @Test
  public void wordDefinitionsFormIsDisplayed() {
    goTo("http://localhost:4567/words/new");
    fill("#name").with("Shopping");
    submit(".btn");
    click("a", withText("View words"));
    click("a", withText("Shopping"));
    click("a", withText("Add a new definition"));
    assertThat(pageSource()).contains("Add a definition to Shopping");
  }

  @Test
  public void definitionsIsAddedAndDisplayed() {
    goTo("http://localhost:4567/words/new");
    fill("#name").with("Banking");
    submit(".btn");
    click("a", withText("View words"));
    click("a", withText("Banking"));
    click("a", withText("Add a new definition"));
    fill("#wordMeaning").with("Deposit paycheck");
    submit(".btn");
    click("a", withText("View words"));
    click("a", withText("Banking"));
    assertThat(pageSource()).contains("Deposit paycheck");
  }
}
