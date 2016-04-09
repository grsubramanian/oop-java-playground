package gokul2411s.projects.patternsrepo.transformation;

import com.google.common.base.Function;

/**
 * Represents a transformer that can process a {@link T} and return a {@link T}.
 */
public interface Transformer<T> extends Function<T, T> {}
