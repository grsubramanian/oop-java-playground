package gokul2411s.projects.patternsrepo.investing;

import com.google.common.base.Optional;
import org.joda.time.Instant;
import org.joda.time.LocalDate;

/**
 * A value type representing an investor in financial markets.
 */
class Investor {

  private final String name;
  private final Optional<Integer> numInvestments;
  private final Optional<LocalDate> dateOfBirth;


  private Investor(String name, Optional<Integer> numInvestments, Optional<LocalDate> dateOfBirth) {
    this.name = name;
    this.numInvestments = numInvestments;
    this.dateOfBirth = dateOfBirth;
  }

  String getName() {
    return this.name;
  }

  Optional<Integer> getNumInvestments() {
    return numInvestments;
  }

  Optional<LocalDate> getDateOfBirth() {
    return dateOfBirth;
  }

  static Builder newBuilder(String name) {
    return new Builder(name);
  }

  static class Builder {

    private String name;
    private Optional<Integer> numInvestments;
    private Optional<LocalDate> dateOfBirth = Optional.absent();

    Builder(String name) {
      this.name = name;
    }

    Builder setNumInvestments(int numInvestments) {
      this.numInvestments = Optional.of(numInvestments);
      return this;
    }

    Builder setDateOfBirth(LocalDate dateOfBirth) {
      this.dateOfBirth = Optional.of(dateOfBirth);
      return this;
    }

    Investor build() {
      return new Investor(name, numInvestments, dateOfBirth);
    }
  }
}
