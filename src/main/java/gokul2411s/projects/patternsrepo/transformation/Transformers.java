package gokul2411s.projects.patternsrepo.transformation;

/**
 * Factory class for producing instances of {@link Transformer}.
 *
 * <p>This represents the public API for this package.
 */
public final class Transformers {

  public static <T> Transformer<T> noopTransformerImpl() {
    return new NoopTransformerImpl<>();
  }

  private Transformers() {}
}
