package gokul2411s.projects.patternsrepo.editor;

import gokul2411s.projects.patternsrepo.command.ReversibleCommand;

/**
 * A simple implementation of {@link ReversibleCommand} that appends ASCII chars to text.
 */
class AppendCharCommand implements ReversibleCommand {

  private final AsciiText asciiText;
  private final char asciiCharToAppend;

  AppendCharCommand(AsciiText asciiText, char asciiCharToAppend) {
    this.asciiText = asciiText;
    this.asciiCharToAppend = asciiCharToAppend;
  }

  @Override
  public void execute() {
    asciiText.append(asciiCharToAppend);
  }

  @Override
  public void reverse() {
    asciiText.delete(asciiText.size() - 1);
  }
}
