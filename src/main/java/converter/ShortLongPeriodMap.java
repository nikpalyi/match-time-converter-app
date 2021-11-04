package converter;

import converter.constants.enums.LongOutputPeriod;
import converter.constants.enums.ShortInputPeriod;
import java.util.HashMap;
import java.util.Map;

public class ShortLongPeriodMap {

  private ShortLongPeriodMap() {
    throw new IllegalStateException("PeriodMap class");
  }

  public static final Map<String, String> PERIOD_MAP;

  static {
    PERIOD_MAP = new HashMap<>();
    PERIOD_MAP.put(ShortInputPeriod.PM.getShortForm(), LongOutputPeriod.PRE_MATCH.getLongForm());
    PERIOD_MAP.put(ShortInputPeriod.H1.getShortForm(), LongOutputPeriod.FIRST_HALF.getLongForm());
    PERIOD_MAP.put(ShortInputPeriod.HT.getShortForm(), LongOutputPeriod.HALF_TIME.getLongForm());
    PERIOD_MAP.put(ShortInputPeriod.H2.getShortForm(), LongOutputPeriod.SECOND_HALF.getLongForm());
    PERIOD_MAP.put(ShortInputPeriod.FT.getShortForm(), LongOutputPeriod.FULL_TIME.getLongForm());
  }
}
