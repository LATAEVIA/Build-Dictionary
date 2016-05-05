import java.util.ArrayList;

public class Definition {
  private String mWordMeaning;
  private static ArrayList<Definition> instances = new ArrayList<Definition>();
  private int mId;

  public Definition(String WordMeaning) {
    mWordMeaning = WordMeaning;
    instances.add(this);
    mId = instances.size();
  }

  public String getWordMeaning() {
    return mWordMeaning;
  }

  public static ArrayList<Definition> all() {
  return instances;
  }

  public static void clear() {
  instances.clear();
  }

  public int getId() {
  return mId;
  }

  public static Definition find(int id) {
    try {
      //Using try, we tell Java to run a block of code, and then we can tell Java to catch specific exceptions and run some other code instead.
      return instances.get(id - 1);
    } catch (IndexOutOfBoundsException exception) {
      return null;
    }
  }

}
