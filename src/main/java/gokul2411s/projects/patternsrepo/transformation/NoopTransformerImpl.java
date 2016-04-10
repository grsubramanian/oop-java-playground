package gokul2411s.projects.patternsrepo.transformation;

/**
 * A transformer that returns input as is.
 */
class NoopTransformerImpl<T> implements Transformer<T> {

  @Override
  public T apply(T input) {
    return input;
  }
}
