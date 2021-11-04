package converter.service;

import converter.constants.ConverterConstants;
import converter.constants.Errors;
import converter.domain.ShortLongPeriodMap;
import converter.util.StringUtil;
import converter.validation.MatchTimeValidator;
import java.util.ArrayList;
import java.util.List;

public class MatchTimeConverter implements ConverterInterface {

  @Override
  public List<String> convert(List<String> rows) {
    return validateAndFormat((MatchTimeValidator.markInvalid(rows)));
  }

  private List<String> validateAndFormat(List<String> rows) {
    List<String> processedList = new ArrayList<>();
    for (String row : rows) {
      if (row.equals(Errors.INVALID)) {
        processedList.add(row);
      } else {
        String periodName = row.substring(1, 3);
        String processedLine =
            StringUtil.formatMatchTime(row.substring(5), periodName)
                + ConverterConstants.CHAR_DASH
                + ShortLongPeriodMap.PERIOD_MAP.get(periodName);
        processedList.add(processedLine);
      }
    }
    return processedList;
  }
}
