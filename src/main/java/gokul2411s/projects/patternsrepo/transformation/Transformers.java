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

  /**
   * Gets the decorated transformer whose application is equivalent to first applying the base
   * transformation on the input and then, on this value, applying the decorator's transformation.
   */
  public static <T> Transformer<T> getDecoratedTransformer(
      final Transformer<T> base, final Transformer<T> decorator) {
    return new Transformer<T>() {
      @Override
      public T apply(T input) {
        return decorator.apply(base.apply(input));
      }
    };
  }

  private Transformers() {}
}
