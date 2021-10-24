package constants.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum PeriodShortForm {
  PM("[PM]"),
  H1("[H1]"),
  HT("[HT]"),
  H2("[H2]"),
  FT("[FT]");

  private String periodShortForm;
}
