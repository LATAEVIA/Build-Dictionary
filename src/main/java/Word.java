import java.util.ArrayList;

public class Word {
  private String mName;
  private static ArrayList<Word> instances = new ArrayList<Word>();
  private int mId;
  private ArrayList<Definition> mDefinitions;

  public Word(String name) {
    mName = name;
    instances.add(this);
    mId = instances.size();
    mDefinitions = new ArrayList<Definition>();
  }

  public String getName() {
    return mName;
  }

  public static ArrayList<Word> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

  public int getId() {
    return mId;
  }

  public static Word find(int id) {
    try {
      return instances.get(id - 1);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }

  public ArrayList<Definition> getDefinitions() {
    return mDefinitions;
  }

  public void addDefinition(Definition definition) {
    //void = no return, just action
    mDefinitions.add(definition);
  }
}
