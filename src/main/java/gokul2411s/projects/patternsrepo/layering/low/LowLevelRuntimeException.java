package gokul2411s.projects.patternsrepo.layering.low;

/**
 * Represents a general unchecked exception created at the low level.
 *
 * <p>There is no additional state here exception what is provided by {@link RuntimeException}, but
 * a real implementation would have more interesting structure.
 */
public final class LowLevelRuntimeException extends RuntimeException {

  LowLevelRuntimeException(String message) {
    super(message);
  }

  LowLevelRuntimeException(Throwable cause) {
    super(cause);
  }

  LowLevelRuntimeException(String message, Throwable cause) {
    super(message, cause);
  }
}
