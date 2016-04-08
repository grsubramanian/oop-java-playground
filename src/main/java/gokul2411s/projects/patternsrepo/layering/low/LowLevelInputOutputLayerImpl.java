package gokul2411s.projects.patternsrepo.layering.low;

import java.io.IOException;

/**
 * Simple implementation of {@link LowLevelInputOutputLayer}.
 */
class LowLevelInputOutputLayerImpl implements LowLevelInputOutputLayer {

  @Override
  public void doInputOutput() throws IOException {
    if (System.nanoTime() % 2 == 0) {
      throw new IOException("Could not read IO channel");
    }
  }
}
