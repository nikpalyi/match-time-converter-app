package converter.util;

import static converter.constants.enums.ShortInputPeriod.H1;
import static converter.constants.enums.ShortInputPeriod.H2;

public class TimeUtil {

  private TimeUtil() {
    throw new IllegalStateException("TimeUtil class");
  }

  public static int minutesInPeriod(String period, int minutes) {
    if (period.equals(H1.getShortForm()) && isExtraTime(period, minutes)) return 45;
    else if (period.equals(H2.getShortForm()) && isExtraTime(period, minutes)) return 90;
    return 0;
  }

  public static boolean isExtraTime(String periodName, int minutes) {
    return (periodName.equals(H1.getShortForm()) && minutes >= 45)
        || (periodName.equals(H2.getShortForm()) && minutes >= 90);
  }

  public static int roundToMinute(int milliSeconds) {
    return milliSeconds >= 500 ? 1 : 0;
  }
}
