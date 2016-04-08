package gokul2411s.projects.patternsrepo.layering.low;

import java.io.IOException;

/**
 * Simple implementation of {@link LowLevelLayer}.
 */
class LowLevelLayerImpl implements LowLevelLayer {

  private final LowLevelInputOutputLayer lowLevelInputOutputLayer;
  private final LowLevelMessagingLayer lowLevelMessagingLayer;

  LowLevelLayerImpl(
      LowLevelInputOutputLayer lowLevelInputOutputLayer,
      LowLevelMessagingLayer lowLevelMessagingLayer) {
    this.lowLevelInputOutputLayer = lowLevelInputOutputLayer;
    this.lowLevelMessagingLayer = lowLevelMessagingLayer;
  }

  @Override
  public void doInputOutput() throws LowLevelException {
    try {
      lowLevelInputOutputLayer.doInputOutput();
    } catch (IOException e) {
      throw new LowLevelException("Could not perform IO", e);
    }
  }

  /**
   * @throws LowLevelRuntimeException if an unrecoverable situation is encountered while getting
   *     message
   */
  @Override
  public LowLevelMessage getMessage() {
    try {
      return lowLevelMessagingLayer.getMessage();
    } catch (RuntimeException e) {
      throw new LowLevelRuntimeException("Unrecoverable exception while getting message", e);
    }
  }
}
