package converter.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TimeUtilTest {

  public static final String PERIOD_H1 = "H1";
  public static final String PERIOD_H2 = "H2";
  public static final String PERIOD_DUMMY = "DUMMY";

  @Test
  void testMinutesInPeriod() {
    assertEquals(0, TimeUtil.minutesInPeriod(PERIOD_DUMMY, 1));
    assertEquals(0, TimeUtil.minutesInPeriod(PERIOD_H1, 1));
    assertEquals(0, TimeUtil.minutesInPeriod(PERIOD_H2, 1));
    assertEquals(45, TimeUtil.minutesInPeriod(PERIOD_H1, 45));
    assertEquals(90, TimeUtil.minutesInPeriod(PERIOD_H2, 90));
  }

  @Test
  void testIsExtraTime() {
    assertFalse(TimeUtil.isExtraTime(PERIOD_DUMMY, 1));
    assertFalse(TimeUtil.isExtraTime(PERIOD_H1, 1));
    assertFalse(TimeUtil.isExtraTime(PERIOD_H2, 1));
    assertTrue(TimeUtil.isExtraTime(PERIOD_H1, 45));
    assertTrue(TimeUtil.isExtraTime(PERIOD_H2, 90));
  }

  @Test
  void testRoundToMinute() {
    assertEquals(0, TimeUtil.roundToMinute(1));
    assertEquals(1, TimeUtil.roundToMinute(500));
  }
}
