package converter;

import static converter.constants.ConverterConstants.*;
import static converter.constants.enums.ShortInputPeriod.*;

import converter.constants.ConverterConstants;
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
    return INVALID;
  }

  private static boolean isValid(String row) {
    int length = row.length();

    if (length < ConverterConstants.MIN_LENGTH || length > MAX_LENGTH) return false;

    String timeStamp = row.substring(4, length);
    if (!isMatchesWithPattern(timeStamp)) return false;

    if (!isPeriodShortLongValid(periodWithBrackets, timeStamp.trim())) return false;
    
    String periodWithBrackets = row.substring(1, 3);
    if (!ShortLongPeriodMap.PERIOD_MAP.containsKey(periodWithBrackets)) return false;
    
    if (row.charAt(0) != '[' || row.charAt(3) != ']') return false;

    return true;
  }

  private static boolean isPeriodShortLongValid(String periodWithBrackets, String timeStamp) {
    if (periodWithBrackets.equals(PM.getShortForm()) && !timeStamp.equals(PRE_MATCH_LONG)) {
      return false;
    } else if (periodWithBrackets.equals(HT.getShortForm()) && !timeStamp.equals(HALF_TIME_LONG)) {
      return false;
    } else if (periodWithBrackets.equals(FT.getShortForm()) && !timeStamp.equals(FULL_TIME_LONG)) {
      return false;
    }
    return true;
  }

  private static boolean isMatchesWithPattern(String time) {
    return TIME_PATTERN.matcher(time).matches();
  }

  public static boolean checkIfValidFile(String fileName) {
    File dataFile = new File(fileName);
    return dataFile.exists();
  }
}
