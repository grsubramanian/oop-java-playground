package gokul2411s.projects.patternsrepo.layering.high;

import gokul2411s.projects.patternsrepo.layering.low.*;

/**
 * Factory class for producing instances of {@link HighLevelLayer}.
 *
 * <p>This represents the public API for this package.
 */
public final class HighLevelLayers {

  public static HighLevelLayer defaultImpl(LowLevelLayer lowLevelLayer) {
    return new HighLevelLayerImpl(lowLevelLayer);
  }

  private HighLevelLayers() {}
}
