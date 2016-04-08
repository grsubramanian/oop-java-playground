package gokul2411s.projects.patternsrepo.layering.high;

/**
 * Represents a general unchecked exception created at the high level.
 *
 * <p>There is no additional state here exception what is provided by {@link RuntimeException}, but
 * a real implementation would have more interesting structure.
 */
public final class HighLevelRuntimeException extends RuntimeException {

  HighLevelRuntimeException(String message) {
    super(message);
  }

  HighLevelRuntimeException(Throwable cause) {
    super(cause);
  }

  HighLevelRuntimeException(String message, Throwable cause) {
    super(message, cause);
  }
}
