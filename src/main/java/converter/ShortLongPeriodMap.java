package converter;

import static converter.constants.enums.LongOutputPeriod.FIRST_HALF;
import static converter.constants.enums.LongOutputPeriod.FULL_TIME;
import static converter.constants.enums.LongOutputPeriod.HALF_TIME;
import static converter.constants.enums.LongOutputPeriod.PRE_MATCH;
import static converter.constants.enums.LongOutputPeriod.SECOND_HALF;
import static converter.constants.enums.ShortInputPeriod.FT;
import static converter.constants.enums.ShortInputPeriod.H1;
import static converter.constants.enums.ShortInputPeriod.H2;
import static converter.constants.enums.ShortInputPeriod.HT;
import static converter.constants.enums.ShortInputPeriod.PM;

import java.util.HashMap;
import java.util.Map;

public class ShortLongPeriodMap {

  private ShortLongPeriodMap() {
    throw new IllegalStateException("PeriodMap class");
  }

  protected static final Map<String, String> PERIOD_MAP;

  static {
    PERIOD_MAP = new HashMap<>();
    PERIOD_MAP.put(PM.getShortForm(), PRE_MATCH.getLongForm());
    PERIOD_MAP.put(H1.getShortForm(), FIRST_HALF.getLongForm());
    PERIOD_MAP.put(HT.getShortForm(), HALF_TIME.getLongForm());
    PERIOD_MAP.put(H2.getShortForm(), SECOND_HALF.getLongForm());
    PERIOD_MAP.put(FT.getShortForm(), FULL_TIME.getLongForm());
  }
}
