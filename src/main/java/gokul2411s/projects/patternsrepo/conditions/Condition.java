package gokul2411s.projects.patternsrepo.conditions;

/**
 * Represents a condition.
 */
public interface Condition<T> {

  Truth satisfiedBy(T entity);

  Condition<T> and(Condition<T> anotherCondition);

  Condition<T> or(Condition<T> anotherCondition);

  Condition<T> not();
}
