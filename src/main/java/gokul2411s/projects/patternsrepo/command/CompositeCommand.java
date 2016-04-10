package gokul2411s.projects.patternsrepo.command;

import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * A composite {@link ReversibleCommand} potentially consisting of other commands.
 */
public class CompositeCommand implements ReversibleCommand {

  private final ImmutableList<ReversibleCommand> subCommands;

  public CompositeCommand(List<ReversibleCommand> subCommands) {
    this.subCommands = ImmutableList.copyOf(subCommands);
  }

  @Override
  public void execute() {
    for (ReversibleCommand subCommand : subCommands) {
      subCommand.execute();
    }
  }

  @Override
  public void reverse() {
    for (ReversibleCommand subCommand : subCommands.reverse()) {
      subCommand.reverse();
    }
  }
}
