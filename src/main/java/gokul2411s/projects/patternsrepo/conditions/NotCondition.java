package gokul2411s.projects.patternsrepo.conditions;

/**
 * Represents an NOT condition.
 */
class NotCondition<T> extends AbstractCondition<T> {

  private final Condition<T> base;

  NotCondition(Condition<T> base) {
    this.base = base;
  }

  @Override
  public Truth satisfiedBy(T entity) {
    return Truth.not(base.satisfiedBy(entity));
  }
}
