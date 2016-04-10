package gokul2411s.projects.patternsrepo.command;

import com.google.common.base.Preconditions;
import gokul2411s.projects.patternsrepo.events.EventObserver;

import java.util.Stack;

/**
 * A simple stack-based implementation of {@link StatefulInvoker}.
 */
class StatefulInvokerImpl implements StatefulInvoker {

  private final Stack<ReversibleCommand> commands = new Stack<>();

  @Override
  public void react(ReversibleCommand event) {
    event.execute();
    commands.add(event);
  }

  @Override
  public void undo() {
    Preconditions.checkState(!commands.empty(), "Nothing to undo");
    ReversibleCommand last = commands.pop();
    last.reverse();
  }
}
