package gokul2411s.projects.patternsrepo.command;

/**
 * Represents a command, which can be executed and whose execution side-effects can be reversed.
 */
public interface ReversibleCommand {

  void execute();

  void reverse();
}
