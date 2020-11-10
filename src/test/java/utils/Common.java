package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Common {

    public String generateStringFromResource(String path) throws IOException {

        return new String(Files.readAllBytes(Paths.get(path)));

    }
}
