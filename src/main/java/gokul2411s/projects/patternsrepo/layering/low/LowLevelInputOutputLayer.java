package gokul2411s.projects.patternsrepo.layering.low;

import java.io.IOException;

/**
 * Represents a layer providing low level services related to IO.
 */
interface LowLevelInputOutputLayer {
  void doInputOutput() throws IOException;
}
