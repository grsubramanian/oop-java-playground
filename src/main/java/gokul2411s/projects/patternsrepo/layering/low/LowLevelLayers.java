package gokul2411s.projects.patternsrepo.layering.low;

/**
 * Factory class for producing instances of {@link LowLevelLayer}.
 *
 * <p>This represents the public API for this package.
 */
public final class LowLevelLayers {

  public static LowLevelLayer defaultImpl() {
    return new LowLevelLayerImpl(
        new LowLevelInputOutputLayerImpl(),
        new LowLevelMessagingLayerImpl());
  }

  private LowLevelLayers() {}
}
