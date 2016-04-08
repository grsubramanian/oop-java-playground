package gokul2411s.projects.patternsrepo.layering.low;

/**
 * Represents a message generated at a low level.
 */
public final class LowLevelMessage {
  private final int id;
  private final String name;

  LowLevelMessage(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
