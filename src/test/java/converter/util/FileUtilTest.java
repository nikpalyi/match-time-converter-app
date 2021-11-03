package converter.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class FileUtilTest {
  @Test
  void testReadFile() {
    assertFalse(FileUtil.readFile("src/main/resources/testData.txt").isEmpty());
    assertTrue(FileUtil.readFile("/tmp/foo.txt").isEmpty());
  }
}
