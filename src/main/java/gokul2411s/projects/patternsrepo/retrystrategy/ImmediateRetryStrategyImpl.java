package gokul2411s.projects.patternsrepo.retrystrategy;

import com.google.common.base.Preconditions;

import java.util.concurrent.Callable;

/**
 * Implementation of {@link RetryStrategy} which retries a given number of times immediately one
 * after the other.
 */
class ImmediateRetryStrategyImpl<V> implements RetryStrategy<V> {

  private final int numRetries;

  ImmediateRetryStrategyImpl(int numRetries) {
    Preconditions.checkArgument(numRetries > 0, "Number of retries must be positive");
    this.numRetries = numRetries;
  }

  @Override
  public V call(Callable<V> callable) throws Exception {

    Exception lastThrown = null;
    for (int i = 0; i < numRetries; i++) {
      try {
        return callable.call();
      } catch (Exception e) {
        e.printStackTrace();
        lastThrown = e;
      }
    }

    // If we got so far, then all retries failed.
    throw new Exception("Retry failed", lastThrown);
  }
}
