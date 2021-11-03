package converter;

import static converter.MatchTimeValidator.markInvalid;
import static converter.constants.ConverterConstants.CHAR_DASH;
import static converter.constants.ConverterConstants.INVALID;
import static converter.util.StringUtil.formatMatchTime;

import java.util.ArrayList;
import java.util.List;

public class MatchTimeConverter {

  public List<String> convert(List<String> rows) {
    return formatAndValidate((markInvalid(rows)));
  }

  private List<String> formatAndValidate(List<String> rows) {
    List<String> processedList = new ArrayList<>();
    for (String row : rows) {
      if (row.equals(INVALID)) {
        processedList.add(row);
      } else {
        String periodName = row.substring(1, 3);
        String processedLine =
            formatMatchTime(row.substring(5), periodName)
                + CHAR_DASH
                + ShortLongPeriodMap.PERIOD_MAP.get(periodName);
        processedList.add(processedLine);
      }
    }
    return processedList;
  }
}
