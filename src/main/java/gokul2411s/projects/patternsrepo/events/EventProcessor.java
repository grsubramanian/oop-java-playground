package gokul2411s.projects.patternsrepo.events;

/**
 * Represents a processor that can act as both an observer and source for events.
 */
public interface EventProcessor<T> extends EventObserver<T>, EventSource<T> {}
