package converter.constants.enums;

public enum LongOutputPeriod {
  PRE_MATCH("PRE_MATCH"),
  FIRST_HALF("FIRST_HALF"),
  HALF_TIME("HALF_TIME"),
  SECOND_HALF("SECOND_HALF"),
  FULL_TIME("FULL_TIME");

  private String longForm;

  public String getLongForm() {
    return this.longForm;
  }

  LongOutputPeriod(String longOutputPeriod) {
    this.longForm = longOutputPeriod;
  }
}
