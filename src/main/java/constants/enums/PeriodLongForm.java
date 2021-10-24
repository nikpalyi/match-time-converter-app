package constants.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum PeriodLongForm {
  PRE_MATCH,
  FIRST_HALF,
  HALF_TIME,
  SECOND_HALF,
  FULL_TIME;
}
