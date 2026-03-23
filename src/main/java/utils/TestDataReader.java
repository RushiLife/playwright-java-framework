package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONObject;

public class TestDataReader {

    public static JSONObject getTestData() {

        String path = System.getProperty("user.dir") +
                "/src/test/resources/testdata/amazonTestData.json";

        try {
            String content = new String(Files.readAllBytes(Paths.get(path)));
            return new JSONObject(content);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read test data file");
        }
    }
    
}
