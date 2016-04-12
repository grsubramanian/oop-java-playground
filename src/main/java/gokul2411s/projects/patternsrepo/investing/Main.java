package gokul2411s.projects.patternsrepo.investing;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import gokul2411s.projects.patternsrepo.conditions.Condition;
import gokul2411s.projects.patternsrepo.conditions.Truth;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Map;

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
    ImmutableMap<String, Condition<Investor>> conditions =
        ImmutableMap.of("savvy", savvy, "highly risky", highlyRisky, "conservative", conservative);

    Investor gokul =
        Investor.newBuilder("Gokul")
            .setDateOfBirth(dob("24/11/1986"))
            .setNumInvestments(60)
            .build();
    Investor vikram =
        Investor.newBuilder("Vikram")
            .setDateOfBirth(dob("13/07/1993"))
            .setNumInvestments(100)
            .build();
    Investor deepak =
        Investor.newBuilder("Deepak")
            .setDateOfBirth(dob("05/10/1992"))
            .setNumInvestments(40)
            .build();
    Investor hari =
        Investor.newBuilder("Hari")
            .setDateOfBirth(dob("25/05/1988"))
            .build();
    ImmutableList<Investor> investors = ImmutableList.of(gokul, vikram, deepak, hari);

    // Profile the various investors according to the various conditions.
    for (Investor investor : investors) {
      ImmutableList.Builder<String> qualifiersBuilder = ImmutableList.builder();
      for (Map.Entry<String, Condition<Investor>> conditionEntry : conditions.entrySet()) {
        String conditionName = conditionEntry.getKey();
        Truth truth = conditionEntry.getValue().satisfiedBy(investor);
        switch (truth) {
          case TRUE:
            qualifiersBuilder.add("is " + conditionName);
            break;
          case FALSE:
            qualifiersBuilder.add("is not " + conditionName);
            break;
          default:
            qualifiersBuilder.add("may or may not be " + conditionName);
            break;
        }
      }

      String qualification = Joiner.on(",").join(qualifiersBuilder.build());
      System.out.println(investor.getName() + " " + qualification);
    }
  }

  private static LocalDate dob(String ddMMyyyy) {
    return LocalDate.parse(ddMMyyyy, DTF);
  }
}
