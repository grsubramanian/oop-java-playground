package gokul2411s.projects.patternsrepo.layering.high;

/**
 * Represents a general exception created at the high level.
 *
 * <p>There is no additional state here exception what is provided by {@link Exception}, but a real
 * implementation would have more interesting structure.
 */
public class HighLevelException extends Exception {

  HighLevelException(String message) {
    super(message);
  }

  HighLevelException(Throwable cause) {
    super(cause);
  }

  HighLevelException(String message, Throwable cause) {
    super(message, cause);
  }
}
