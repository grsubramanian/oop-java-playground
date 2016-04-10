package gokul2411s.projects.patternsrepo.editor;

import gokul2411s.projects.patternsrepo.command.ReversibleCommand;

/**
 * A simple implementation of {@link ReversibleCommand} that inserts ASCII chars into text.
 */
class InsertCharCommand implements ReversibleCommand {

  private final AsciiText asciiText;
  private final char asciiCharToInsert;
  private final int indexToInsert;

  InsertCharCommand(AsciiText asciiText, char asciiCharToInsert, int indexToInsert) {
    this.asciiText = asciiText;
    this.asciiCharToInsert = asciiCharToInsert;
    this.indexToInsert = indexToInsert;
  }

  @Override
  public void execute() {
    asciiText.insert(asciiCharToInsert, indexToInsert);
  }

  @Override
  public void reverse() {
    asciiText.delete(indexToInsert);
  }
}
