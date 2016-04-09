package gokul2411s.projects.patternsrepo.pipeline;

/**
 * Represents a unit of textual work.
 */
public class WorkUnit {
  private final String text;

  public WorkUnit(String text) {
    this.text = text;
  }

  public String getText() {
    return text;
  }

  @Override
  public String toString() {
    return text;
  }
}
