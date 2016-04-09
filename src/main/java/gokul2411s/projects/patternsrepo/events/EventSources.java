package gokul2411s.projects.patternsrepo.events;

import java.io.Writer;
import java.util.List;

/**
 * Factory class for producing instances of {@link EventSource}.
 *
 * <p>This represents a public API for this package.
 */
public final class EventSources {

  public static <T> EventSource<T> fixedObserversEventSourceImpl(List<EventObserver<T>> observers) {
    return new FixedObserversEventSourceImpl<>(observers);
  }

  public static <T> EventSource<T> printingEventSourceImpl(Writer writer) {
    return new PrintingEventSourceImpl<>(writer);
  }

  private EventSources() {}
}
