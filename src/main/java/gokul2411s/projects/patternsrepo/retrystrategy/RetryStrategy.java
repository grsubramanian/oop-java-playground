package gokul2411s.projects.patternsrepo.retrystrategy;

import java.util.concurrent.Callable;

/**
 * Represents retry strategies.
 */
public interface
RetryStrategy<V> {

  V call(Callable<V> callable) throws Exception;
}
