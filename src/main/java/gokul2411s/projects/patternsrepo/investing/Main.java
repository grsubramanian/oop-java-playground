package gokul2411s.projects.patternsrepo.investing;

import com.google.common.collect.ImmutableList;
import gokul2411s.projects.patternsrepo.conditions.Condition;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import static gokul2411s.projects.patternsrepo.conditions.AbstractCondition.not;

/**
 * A sample application indication how complex business rules can be expressed as conditions.
 */
class Main {

  private static final DateTimeFormatter DTF = DateTimeFormat.forPattern("dd/MM/yyyy");

  public static void main(String[] args) {

    ExperiencedInvestorCondition experienced = new ExperiencedInvestorCondition();
    YoungInvestorCondition young = new YoungInvestorCondition();

    Condition<Investor> savvy = young.and(experienced);
    Condition<Investor> highlyRisky = young.and(not(experienced));
    Condition<Investor> conservative = not(young).and(experienced);
    ImmutableList<Condition<Investor>> conditions =
        ImmutableList.of(savvy, highlyRisky, conservative);

    Investor gokul =
        Investor.newBuilder("Gokul")
            .setDateOfBirth(LocalDate.parse("24/11/1986", DTF))
            .build();
    Investor vikram =
        Investor.newBuilder("Vikram")
            .setDateOfBirth(LocalDate.parse("13/07/1980", DTF))
            .setNumInvestments(100)
            .build();
    Investor deepak =
        Investor.newBuilder("Deepak")
            .setDateOfBirth(LocalDate.parse("05/10/1992", DTF))
            .setNumInvestments(40)
            .build();
    ImmutableList<Investor> investors = ImmutableList.of(gokul, vikram, deepak);

    // Profile the various investors according to the various conditions.
    for (Investor investor : investors) {
      // TODO: Implement this.
    }
  }
}
