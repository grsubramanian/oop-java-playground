package gokul2411s.projects.patternsrepo.command;

/**
 * Factory class for producing instances of {@link StatefulInvoker}.
 *
 * <p>This represents a public API for this package.
 */
public final class StatefulInvokers {

  public static StatefulInvoker defaultImpl() {
    return new StatefulInvokerImpl();
  }

  private StatefulInvokers() {}
}
