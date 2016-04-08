package gokul2411s.projects.patternsrepo.layering.low;

/**
 * Simple implementation of the {@link LowLevelMessagingLayer}.
 */
class LowLevelMessagingLayerImpl implements LowLevelMessagingLayer {

  @Override
  public LowLevelMessage getMessage() {
    if (System.nanoTime() % 2 == 0) {
      throw new RuntimeException("No low level messages");
    }
    return new LowLevelMessage(1, "Name1");
  }
}
