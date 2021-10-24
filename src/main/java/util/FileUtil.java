package util;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
//public class FileUtil {
//
//    public static List<String> readFile(String inputFile) {
//
//        List<String> contentBuilder = new ArrayList<>();
//
//        if (inputFile.isEmpty()) {
//            log.debug("Input file is empty");
//
//            try (Stream<String> stream = Files.lines(Paths.get(inputFile), StandardCharsets.UTF_8)) {
//
//                stream.forEach(contentBuilder::add);
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return contentBuilder;
//    }
//}

public class FileUtil {

    public static List<String> readLineByLine(String inputFile) {
        List<String> contentBuilder = new ArrayList<>();

        if (inputFile.isEmpty()) {
            log.debug("Input file is empty");
        }

        try (Stream<String> stream = Files.lines(Paths.get(inputFile), StandardCharsets.UTF_8)) {
            stream.forEach(contentBuilder::add);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder;
    }
}