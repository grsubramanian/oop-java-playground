package gokul2411s.projects.patternsrepo.events;

/**
 * Represents sources that generate events of type {@link T}.
 */
public interface EventSource<T> {
  void generate(T event);
}
