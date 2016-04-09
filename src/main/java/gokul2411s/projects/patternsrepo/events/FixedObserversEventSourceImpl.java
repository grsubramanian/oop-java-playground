package gokul2411s.projects.patternsrepo.events;

import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * A simple implementation of {@link EventSource} with a fixed set of {@link EventObserver}s.
 */
final class FixedObserversEventSourceImpl<T> implements EventSource<T> {

  private final ImmutableList<EventObserver<T>> observers;

  FixedObserversEventSourceImpl(List<EventObserver<T>> observers) {
    this.observers = ImmutableList.copyOf(observers);
  }

  @Override
  public void generate(T event) {
    for (EventObserver<T> observer : observers) {
      observer.react(event);
    }
  }
}
