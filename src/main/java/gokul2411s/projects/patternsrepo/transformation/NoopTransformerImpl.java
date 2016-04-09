package gokul2411s.projects.patternsrepo.transformation;

import gokul2411s.projects.patternsrepo.transformation.Transformer;

/**
 * A transformer that returns input as is.
 */
class NoopTransformerImpl<T> implements Transformer<T> {

  @Override
  public T apply(T input) {
    return input;
  }
}
