package gokul2411s.projects.patternsrepo.conditions;

/**
 * Represents an AND condition.
 */
class AndCondition<T> extends AbstractCondition<T> {

  private final Condition<T> first;
  private final Condition<T> second;

  AndCondition(Condition<T> first, Condition<T> second) {
    this.first = first;
    this.second = second;
  }

  @Override
  public Truth satisfiedBy(T entity) {
    return Truth.and(first.satisfiedBy(entity), second.satisfiedBy(entity));
  }
}
