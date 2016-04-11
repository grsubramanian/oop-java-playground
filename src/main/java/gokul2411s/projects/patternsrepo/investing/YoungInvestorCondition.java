package gokul2411s.projects.patternsrepo.investing;

import gokul2411s.projects.patternsrepo.conditions.AbstractCondition;
import gokul2411s.projects.patternsrepo.conditions.Condition;
import gokul2411s.projects.patternsrepo.conditions.Truth;
import org.joda.time.LocalDate;

/**
 * Represents a {@link Condition} that indicates whether an investor is considered young.
 */
public class YoungInvestorCondition extends AbstractCondition<Investor> {

  @Override
  public Truth satisfiedBy(Investor entity) {
    if (!entity.getDateOfBirth().isPresent()) {
      return Truth.CANT_SAY;
    }
    return (entity.getDateOfBirth().get().getYear() > 1990) ? Truth.TRUE : Truth.FALSE;
  }
}
