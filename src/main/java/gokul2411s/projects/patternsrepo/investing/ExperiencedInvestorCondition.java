package gokul2411s.projects.patternsrepo.investing;

import gokul2411s.projects.patternsrepo.conditions.AbstractCondition;
import gokul2411s.projects.patternsrepo.conditions.Condition;
import gokul2411s.projects.patternsrepo.conditions.Truth;

/**
 * Represents a {@link Condition} that indicates whether an investor is considered experienced.
 */
class ExperiencedInvestorCondition extends AbstractCondition<Investor> {

  @Override
  public Truth satisfiedBy(Investor entity) {
    if (!entity.getNumInvestments().isPresent()) {
      return Truth.CANT_SAY;
    }

    return entity.getNumInvestments().get() > 50 ? Truth.TRUE : Truth.FALSE;
  }
}
