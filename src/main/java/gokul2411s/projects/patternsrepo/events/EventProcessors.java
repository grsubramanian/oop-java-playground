package gokul2411s.projects.patternsrepo.events;

import gokul2411s.projects.patternsrepo.transformation.Transformer;

/**
 * Factory class for producing instances of {@link EventProcessor}.
 *
 * <p>This represents a public API for this package.
 */
public class EventProcessors {

  public static <T> EventProcessor<T> immediatePassThroughProcessorImpl(
      Transformer<T> transformer, EventSource<T> eventSourceDelegate) {
    return new ImmediatePassThroughProcessorImpl<>(transformer, eventSourceDelegate);
  }

  private EventProcessors() {}
}
