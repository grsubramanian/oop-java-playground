package gokul2411s.projects.patternsrepo.layering;

import gokul2411s.projects.patternsrepo.layering.high.HighLevelException;
import gokul2411s.projects.patternsrepo.layering.high.HighLevelLayer;
import gokul2411s.projects.patternsrepo.layering.high.HighLevelLayers;
import gokul2411s.projects.patternsrepo.layering.high.HighLevelMessage;
import gokul2411s.projects.patternsrepo.layering.low.LowLevelLayer;
import gokul2411s.projects.patternsrepo.layering.low.LowLevelLayers;
import gokul2411s.projects.patternsrepo.retrystrategy.RetryStrategies;
import gokul2411s.projects.patternsrepo.retrystrategy.RetryStrategy;

/**
 * Sample application for a layered architecture.
 */
class Main {

  public static void main(String[] args) throws HighLevelException {

    // The following block of code manually obtains instances via factories. In bigger applications,
    // this approach would be replaced by the use of a Dependency Injection framework such as Guice.

    LowLevelLayer lowLevelLayer = LowLevelLayers.defaultImpl();

    HighLevelLayer highLevelLayer = HighLevelLayers.defaultImpl(lowLevelLayer);

    RetryStrategy<Void> retryStrategy = RetryStrategies.defaultImpl();

    HighLevelMessage highLevelMessage = highLevelLayer.getMessage(retryStrategy);
    System.out.println(highLevelMessage.getOne() + ":" + highLevelMessage.getTwo());
  }
}
