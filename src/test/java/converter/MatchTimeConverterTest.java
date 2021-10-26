package converter;

import static converter.constants.ConverterConstants.INVALID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MatchTimeConverterTest {

  private MatchTimeConverter converter;

  private String convertRow(String inputShortForm) {
    return converter.convert(Arrays.asList(inputShortForm)).get(0);
  }

  @BeforeEach
  void setUp() {
    converter = new MatchTimeConverter();
  }

  @Test
  void empty_convert() {
    MatchTimeConverter matchTimeConverter = new MatchTimeConverter();
    assertTrue(matchTimeConverter.convert(new ArrayList<String>()).isEmpty());
  }

  @Test
  void invalid_convert() {
    MatchTimeConverter matchTimeConverter = new MatchTimeConverter();

    ArrayList<String> stringList = new ArrayList<String>();
    stringList.add("foo");
    List<String> actualConvertResult = matchTimeConverter.convert(stringList);
    assertEquals(1, actualConvertResult.size());
    assertEquals(INVALID, actualConvertResult.get(0));
  }

  @Test
  void valid_convert() {
    MatchTimeConverter matchTimeConverter = new MatchTimeConverter();

    ArrayList<String> stringList = new ArrayList<String>();
    stringList.add("foo");
    List<String> actualConvertResult =
        Collections.singletonList(converter.convert(Arrays.asList("[PM] 0:00.000")).get(0));
    assertEquals(1, actualConvertResult.size());
    assertEquals("00:00 - PRE_MATCH", actualConvertResult.get(0));
  }

  @Test
  void return_valid_pre_match() {
    assertEquals("00:00 - PRE_MATCH", convertRow("[PM] 0:00.000"));
  }

  @Test
  void return_valid_full_time() {
    assertEquals("90:00 - FULL_TIME", convertRow("[FT] 90:00.000"));
  }

  @Test
  void valid_half_time() {
    assertEquals("45:00 - HALF_TIME", convertRow("[HT] 45:00.000"));
  }

  @Test
  void return_first_half() {
    assertEquals("00:15 - FIRST_HALF", convertRow("[H1] 0:15.000"));
  }

  @Test
  void return_second_half() {
    assertEquals("45:01 - SECOND_HALF", convertRow("[H2] 45:00.500"));
  }

  @Test
  void return_valid_rounded_first_half() {
    assertEquals("03:08 - FIRST_HALF", convertRow("[H1] 3:07.513"));
  }

  @Test
  void return_first_half_add_time_rounded_up() {
    assertEquals("45:00 +01:16 - FIRST_HALF", convertRow("[H1] 46:15.752"));
  }

  @Test
  void return_first_half_add_time_rounded_down() {
    assertEquals("45:00 +00:00 - FIRST_HALF", convertRow("[H1] 45:00.001"));
  }

  @Test
  void second_half_additional_time() {
    assertEquals("90:00 +00:01 - SECOND_HALF", convertRow("[H2] 90:00.908"));
  }

  @Test
  void return_with_invalid_milliseconds() {
    assertEquals(INVALID, convertRow("[PM] 00:00.001"));
  }

  @Test
  void return_with_invalid_milliseconds2() {
    assertEquals(INVALID, convertRow("[H1] 14:14.4444444"));
  }

  @Test
  void return_with_invalid_pre_match() {
    assertEquals(INVALID, convertRow("[PM] 01:00.000"));
    assertEquals(INVALID, convertRow("[PM] 00:01.000"));
  }

  @Test
  void return_with_invalid_half_time() {
    assertEquals(INVALID, convertRow("[HT] 47:00.000"));
  }

  @Test
  void return_with_invalid_full_time() {
    assertEquals(INVALID, convertRow("[FT] 91:00.000"));
  }

  @Test
  void return_with_invalid_time_format() {
    assertEquals(INVALID, convertRow("[H11] 14:14.000"));
    assertEquals(INVALID, convertRow("[H1] 0:00.0038"));
    assertEquals(INVALID, convertRow("[H1]    0:00.004"));
    assertEquals(INVALID, convertRow("H1] 14:14.000"));
    assertEquals(INVALID, convertRow("[H1] 0:00.00"));
    assertEquals(INVALID, convertRow("[H1] 0.00.004"));
    assertEquals(INVALID, convertRow("[H1]00:00.004"));
    assertEquals(INVALID, convertRow("[H1]0:00.004"));
  }
}
