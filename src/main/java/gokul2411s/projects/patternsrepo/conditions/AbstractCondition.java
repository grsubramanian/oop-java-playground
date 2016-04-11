package gokul2411s.projects.patternsrepo.conditions;

/**
 * Represents a reference implementation of{@link Condition}.
 */
public abstract class AbstractCondition<T> implements Condition<T> {

  /**
   * Subclasses merely need to implement this.
   */
  public abstract Truth satisfiedBy(T entity);

  @Override
  public Condition<T> and(Condition<T> anotherCondition) {
    return new AndCondition<>(this, anotherCondition);
  }

  @Override
  public Condition<T> or(Condition<T> anotherCondition) {
    return new OrCondition<>(this, anotherCondition);
  }

  @Override
  public Condition<T> not() {
    return new NotCondition<>(this);
  }

  public static <T> Condition<T> not(Condition<T> condition) {
    return condition.not();
  }
}
