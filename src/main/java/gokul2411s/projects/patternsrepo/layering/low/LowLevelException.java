package gokul2411s.projects.patternsrepo.layering.low;

/**
 * Represents a general exception created at the low level.
 *
 * <p>There is no additional state here exception what is provided by {@link Exception}, but a real
 * implementation would have more interesting structure.
 */
public final class LowLevelException extends Exception {

  LowLevelException(String message) {
    super(message);
  }

  LowLevelException(Throwable cause) {
    super(cause);
  }

  LowLevelException(String message, Throwable cause) {
    super(message, cause);
  }
}
