package gokul2411s.projects.patternsrepo.events;

/**
 * Represents observers interested in events of type {@link T}.
 */
public interface EventObserver<T> {
  void react(T event);
}
