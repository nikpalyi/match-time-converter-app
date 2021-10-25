package converter.constants.enums;

public enum ShortInputPeriod {
  PM("PM"),
  H1("H1"),
  HT("HT"),
  H2("H2"),
  FT("FT");

  private String shortForm;

  public String getShortForm() {
    return this.shortForm;
  }

  ShortInputPeriod(String shortInputPeriod) {
    this.shortForm = shortInputPeriod;
  }
}
