package gokul2411s.projects.patternsrepo.layering.high;

import gokul2411s.projects.patternsrepo.retrystrategy.RetryStrategy;

/**
 * Represent a layer providing high level services.
 */
public interface HighLevelLayer {
  HighLevelMessage getMessage(RetryStrategy<Void> ioRetryStrategy) throws HighLevelException;
}
