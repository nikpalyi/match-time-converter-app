package converter;

import converter.constants.ConverterConstants;
import converter.constants.Errors;
import converter.constants.enums.ShortInputPeriod;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MatchTimeValidator {

  private MatchTimeValidator() {
    throw new IllegalStateException("MatchTimeValidator class");
  }

  public static List<String> markInvalid(List<String> rows) {
    List<String> validatedRows = new ArrayList<>();
    for (String row : rows) {
      validatedRows.add(validate(row));
    }
    return validatedRows;
  }

  private static String validate(String row) {
    if (isValid(row)) return row;
    return Errors.INVALID;
  }

  private static boolean isValid(String row) {

    int length = row.length();
    if (length < ConverterConstants.MIN_LENGTH || length > ConverterConstants.MAX_LENGTH)
      return false;

    String shortInputPeriod = row.substring(1, 3);
    if (!ShortLongPeriodMap.PERIOD_MAP.containsKey(shortInputPeriod)) return false;

    String timeStamp = row.substring(4, length);
    if (!isMatchesWithPattern(timeStamp)) return false;

    if ((!isPeriodShortLongValid(shortInputPeriod, timeStamp.trim())
        || (row.charAt(0) != '[' || row.charAt(3) != ']'))) return false;
    return true;
  }

  private static boolean isPeriodShortLongValid(String periodWithBrackets, String timeStamp) {
    if ((periodWithBrackets.equals(ShortInputPeriod.PM.getShortForm())
            && !timeStamp.equals(ConverterConstants.PRE_MATCH_LONG)
        || (periodWithBrackets.equals(ShortInputPeriod.HT.getShortForm())
                && !timeStamp.equals(ConverterConstants.HALF_TIME_LONG)
            || (periodWithBrackets.equals(ShortInputPeriod.FT.getShortForm())
                && !timeStamp.equals(ConverterConstants.FULL_TIME_LONG))))) {
      return false;
    }
    return true;
  }

  private static boolean isMatchesWithPattern(String time) {
    return ConverterConstants.TIME_PATTERN.matcher(time).matches();
  }

  public static boolean checkIfValidFile(String fileName) {
    File dataFile = new File(fileName);
    return dataFile.exists();
  }
}
