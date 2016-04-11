package gokul2411s.projects.patternsrepo.conditions;

/**
 * Represents an OR condition.
 */
class OrCondition<T> extends AbstractCondition<T> {

  private final Condition<T> first;
  private final Condition<T> second;

  OrCondition(Condition<T> first, Condition<T> second) {
    this.first = first;
    this.second = second;
  }

  @Override
  public Truth satisfiedBy(T entity) {
    return Truth.or(first.satisfiedBy(entity), second.satisfiedBy(entity));
  }
}
