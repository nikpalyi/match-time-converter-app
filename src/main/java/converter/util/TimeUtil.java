package converter.util;

import converter.constants.enums.ShortInputPeriod;

public class TimeUtil {

  private TimeUtil() {
    throw new IllegalStateException("TimeUtil class");
  }

  public static int minutesInPeriod(String period, int minutes) {
    if (period.equals(ShortInputPeriod.H1.getShortForm()) && isAdditionalTime(period, minutes))
      return 45;
    else if (period.equals(ShortInputPeriod.H2.getShortForm()) && isAdditionalTime(period, minutes))
      return 90;
    return 0;
  }

  public static boolean isAdditionalTime(String periodName, int minutes) {
    return (periodName.equals(ShortInputPeriod.H1.getShortForm()) && minutes >= 45)
        || (periodName.equals(ShortInputPeriod.H2.getShortForm()) && minutes >= 90);
  }

  public static int roundToMinute(int milliSeconds) {
    return milliSeconds >= 500 ? 1 : 0;
  }
}
