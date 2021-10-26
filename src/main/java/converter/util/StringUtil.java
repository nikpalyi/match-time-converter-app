package converter.util;

import static converter.constants.ConverterConstants.*;
import static converter.constants.ConverterConstants.CHAR_COLON;
import static converter.util.TimeUtil.*;

public class StringUtil {

  private StringUtil() {
    throw new IllegalStateException("StringUtil class");
  }

  public static String formatMatchTime(String inputTime, String inputPeriod) {
    if (inputTime.indexOf(CHAR_COLON, 2) > -1) inputTime = paddingWithZero(inputTime);

    inputTime = replaceDotWithColon(inputTime);
    String[] inputTimeElements = inputTime.split(CHAR_COLON);

    int minutes = Integer.parseInt(inputTimeElements[0]);
    int seconds = Integer.parseInt(inputTimeElements[1]);
    int milliSeconds = Integer.parseInt(inputTimeElements[2]);

    return formatMatchTime(
        minutes,
        seconds,
        minutesInPeriod(inputPeriod, minutes),
        roundToMinute(milliSeconds),
        isAdditionalTime(inputPeriod, minutes));
  }

  private static String formatMatchTime(
      int minutes, int seconds, int period, int offset, boolean appendPeriod) {
    return (appendPeriod ? (period + ":00 +") : CHAR_SPACE)
        + formatToOutputNormalTime(minutes, seconds, period, offset);
  }

  private static String formatToOutputNormalTime(int minutes, int seconds, int period, int offset) {
    return String.format(LEFT_PAD_WITH_TWO_ZEROS, (minutes - period))
        + CHAR_COLON
        + String.format(LEFT_PAD_WITH_TWO_ZEROS, (seconds + offset));
  }

  private static String paddingWithZero(String time) {
    return ZERO + time;
  }

  private static String replaceDotWithColon(String time) {
    return time.replace(CHAR_DOT, CHAR_COLON);
  }
}
