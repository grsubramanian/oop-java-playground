package gokul2411s.projects.patternsrepo.editor;

import gokul2411s.projects.patternsrepo.command.ReversibleCommand;

/**
 * A simple implementation of {@link ReversibleCommand} that deletes ASCII chars from text.
 */
class DeleteCharCommand implements ReversibleCommand {

  private final AsciiText asciiText;
  private final int indexToDelete;

  private Character deletedChar = null;

  DeleteCharCommand(AsciiText asciiText, int indexToDelete) {
    this.asciiText = asciiText;
    this.indexToDelete = indexToDelete;
  }

  @Override
  public void execute() {
    deletedChar = asciiText.delete(indexToDelete);
  }

  @Override
  public void reverse() {
    asciiText.insert(deletedChar, indexToDelete);
  }
}
