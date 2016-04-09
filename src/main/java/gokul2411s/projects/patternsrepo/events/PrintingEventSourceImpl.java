package gokul2411s.projects.patternsrepo.events;

import java.io.IOException;
import java.io.Writer;

/**
 * An implementation of {@link EventSource} which prints the event to a given stream.
 */
class PrintingEventSourceImpl<T> implements EventSource<T> {

  private final Writer writer;

  PrintingEventSourceImpl(Writer writer) {
    this.writer = writer;
  }

  @Override
  public void generate(T event) {
    try {
      writer.append(event.toString());
      writer.flush();
    } catch (IOException e) {
      throw new RuntimeException("Failed to print event", e);
    }
  }
}
