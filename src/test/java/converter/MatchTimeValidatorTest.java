package converter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import converter.constants.ConverterConstants;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class MatchTimeValidatorTest {
  @Test
  void testMarkInvalid() {
    assertTrue(MatchTimeValidator.markInvalid(new ArrayList<String>()).isEmpty());
    assertTrue(MatchTimeValidator.markInvalid(new ArrayList<String>()).isEmpty());
    assertTrue(MatchTimeValidator.markInvalid(new ArrayList<String>()).isEmpty());
  }

  @Test
  void testMarkInvalid2() {
    ArrayList<String> stringList = new ArrayList<String>();
    stringList.add("fooo");
    List<String> actualMarkInvalidResult = MatchTimeValidator.markInvalid(stringList);
    assertEquals(1, actualMarkInvalidResult.size());
    assertEquals(ConverterConstants.INVALID, actualMarkInvalidResult.get(0));
  }

  @Test
  void testMarkInvalid3() {
    ArrayList<String> stringList = new ArrayList<String>();
    stringList.add("fooo");
    List<String> actualMarkInvalidResult = MatchTimeValidator.markInvalid(stringList);
    assertEquals(1, actualMarkInvalidResult.size());
    assertEquals(ConverterConstants.INVALID, actualMarkInvalidResult.get(0));
  }

  @Test
  void testCheckIfValidFile() {
    assertFalse(MatchTimeValidator.checkIfValidFile("invalid.txt"));
    assertFalse(MatchTimeValidator.checkIfValidFile("foo.txt"));
    assertFalse(MatchTimeValidator.checkIfValidFile("foo.txt"));
  }
}
