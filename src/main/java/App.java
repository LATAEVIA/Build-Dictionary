import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/word", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String newVocabWord = request.queryParams("vocabWord");
      Word newWord = new Word(newVocabWord);
      String test = newWord.getVocabWord();
      model.put("test", test);
      request.session().attribute("test");
      model.put("template", "templates/fullWords.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    // get("/word", (request, response) -> {
    //   Map<String, Object> model = new HashMap<String, Object>();
    //
    //   String vocabWord = request.queryParams("vocabWord");
    //   Word newWord = new Word(vocabWord);
    //   request.session().attribute("vocabWord", newWord);
    //
    //   model.put("template", "templates/define.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());

  }
}
