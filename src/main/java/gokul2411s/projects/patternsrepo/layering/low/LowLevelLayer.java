package gokul2411s.projects.patternsrepo.layering.low;

/**
 * Represents a facade over all the low-level services.
 */
public interface LowLevelLayer {
  void doInputOutput() throws LowLevelException;

  LowLevelMessage getMessage();
}
