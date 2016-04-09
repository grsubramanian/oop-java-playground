package gokul2411s.projects.patternsrepo.events;

/**
 * Represents events interested in events of type {@link T}.
 */
public interface EventObserver<T> {
  void react(T event);
}
