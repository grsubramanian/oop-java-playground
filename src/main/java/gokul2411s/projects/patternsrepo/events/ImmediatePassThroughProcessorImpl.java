package gokul2411s.projects.patternsrepo.events;

import com.google.common.base.Preconditions;
import gokul2411s.projects.patternsrepo.transformation.Transformer;

/**
 * Represents an event-driven {@link Transformer} that transforms input events immediately into
 * output events and notifies downstream events.
 */
final class ImmediatePassThroughProcessorImpl<T> implements EventProcessor<T> {

  private final Transformer<T> transformer;
  private final EventSource<T> eventSourceDelegate;

  ImmediatePassThroughProcessorImpl(Transformer<T> transformer, EventSource<T> eventSourceDelegate) {
    Preconditions.checkNotNull(transformer);
    Preconditions.checkNotNull(eventSourceDelegate);
    this.transformer = transformer;
    this.eventSourceDelegate = eventSourceDelegate;
  }

  @Override
  public void react(T event) {
    T transformedEvent = transformer.apply(event);
    generate(transformedEvent);
  }

  @Override
  public void generate(T event) {
    eventSourceDelegate.generate(event);
  }
}
