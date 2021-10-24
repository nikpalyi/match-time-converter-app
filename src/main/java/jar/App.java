package jar;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) throws IOException {
        URI path = new File("info.txt").toURI();
        System.out.println(Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8));
    }
}
