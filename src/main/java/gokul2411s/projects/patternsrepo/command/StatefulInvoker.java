package gokul2411s.projects.patternsrepo.command;

import gokul2411s.projects.patternsrepo.events.EventObserver;

/**
 * Represents an {@link EventObserver} that can react to a series of reversible commands.
 */
public interface StatefulInvoker extends EventObserver<ReversibleCommand>, Undoable {}
