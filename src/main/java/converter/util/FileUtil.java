package converter.util;

import static converter.validation.MatchTimeValidator.checkIfValidFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

  private FileUtil() {
    throw new IllegalStateException("FileUtil class");
  }

  public static List<String> readFile(String inputFilePath) {
    List<String> rows = new ArrayList<>();
    boolean isValidFile = checkIfValidFile(inputFilePath);
    if (isValidFile) {
      try {
        Files.lines(Paths.get(inputFilePath)).forEach(rows::add);
        System.out.println("INPUT TEST DATA:");
        rows.forEach(System.out::println);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return rows;
  }
}
