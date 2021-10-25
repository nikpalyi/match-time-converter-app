package converter.util;

import static org.junit.jupiter.api.Assertions.assertThrows;

import converter.constants.ConverterConstants;
import org.junit.jupiter.api.Test;

class StringUtilTest {

  @Test
  void testFormatMatchTime() {
    assertThrows(
        ArrayIndexOutOfBoundsException.class,
        () -> StringUtil.formatMatchTime(ConverterConstants.CHAR_COLON, "Input Period"));
    assertThrows(
        ArrayIndexOutOfBoundsException.class,
        () -> StringUtil.formatMatchTime("42", "Input Period"));
  }
}
