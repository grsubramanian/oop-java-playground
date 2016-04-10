package gokul2411s.projects.patternsrepo.command;

/**
 * Represents a {@link Command} whose side-effects on execution can be reversed.
 */
public interface ReversibleCommand extends Command {
  void reverse();
}
