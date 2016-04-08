package gokul2411s.projects.patternsrepo.layering.high;

import gokul2411s.projects.patternsrepo.layering.low.LowLevelException;
import gokul2411s.projects.patternsrepo.layering.low.LowLevelLayer;
import gokul2411s.projects.patternsrepo.layering.low.LowLevelMessage;
import gokul2411s.projects.patternsrepo.layering.low.LowLevelRuntimeException;
import gokul2411s.projects.patternsrepo.retrystrategy.RetryStrategy;

import java.util.concurrent.Callable;

/**
 * Simple implementation of {@link HighLevelLayer}.
 */
class HighLevelLayerImpl implements HighLevelLayer {

  private final LowLevelLayer lowLevelLayer;

  HighLevelLayerImpl(LowLevelLayer lowLevelLayer) {
    this.lowLevelLayer = lowLevelLayer;
  }

  @Override
  public HighLevelMessage getMessage(RetryStrategy<Void> ioRetryStrategy)
      throws HighLevelException {

    try {
      ioRetryStrategy.call(new LowLevelIoCallable());
    } catch (Exception e) {
      throw new HighLevelException("Could not do IO because retry failed", e);
    }

    try {
      LowLevelMessage lowLevelMessage = lowLevelLayer.getMessage();
      return new HighLevelMessage(
          String.valueOf(lowLevelMessage.getId()), lowLevelMessage.getName());
    } catch (LowLevelRuntimeException e) {
      throw new HighLevelRuntimeException("Could not get message", e);
    }
  }

  /**
   * Encapsulates the call to low-level IO methods.
   */
  private class LowLevelIoCallable implements Callable<Void> {

    @Override
    public Void call() throws Exception {
      lowLevelLayer.doInputOutput();
      return null;
    }
  }
}
