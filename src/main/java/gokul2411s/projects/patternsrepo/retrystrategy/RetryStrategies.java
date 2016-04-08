package gokul2411s.projects.patternsrepo.retrystrategy;

/**
 * Factory class for producing instances of {@link RetryStrategy}.
 *
 * <p>This represents the public API for this package.
 */
public final class RetryStrategies {

  public static <V> RetryStrategy<V> defaultImpl() {
    return new ImmediateRetryStrategyImpl<>(5);
  }

  private RetryStrategies() {}
}
