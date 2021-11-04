package converter.constants;

import java.util.regex.Pattern;

public class ConverterConstants {

  private ConverterConstants() {
    throw new IllegalStateException("ConverterConstants class");
  }

  public static final String PRE_MATCH_LONG = "0:00.000";
  public static final String HALF_TIME_LONG = "45:00.000";
  public static final String FULL_TIME_LONG = "90:00.000";
  public static final int MIN_LENGTH = 13;
  public static final int MAX_LENGTH = 14;
  public static final Pattern TIME_PATTERN = Pattern.compile("\\s\\d{1,2}:\\d{2}.\\d{3}$");

  public static final String CHAR_COLON = ":";
  public static final String CHAR_DASH = " - ";
  public static final String CHAR_SPACE = "";
  public static final String CHAR_DOT = ".";
  public static final String ZERO = "0";
  public static final String LEFT_PAD_WITH_TWO_ZEROS = "%02d";
}
