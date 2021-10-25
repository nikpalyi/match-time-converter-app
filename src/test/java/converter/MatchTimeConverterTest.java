package converter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class MatchTimeConverterTest {
    @Test
    void testConvert() {
        MatchTimeConverter matchTimeConverter = new MatchTimeConverter();
        assertTrue(matchTimeConverter.convert(new ArrayList<String>()).isEmpty());
    }

    @Test
    void testConvert2() {
        MatchTimeConverter matchTimeConverter = new MatchTimeConverter();

        ArrayList<String> stringList = new ArrayList<String>();
        stringList.add("foo");
        List<String> actualConvertResult = matchTimeConverter.convert(stringList);
        assertEquals(1, actualConvertResult.size());
        assertEquals("INVALID", actualConvertResult.get(0));
    }
}

