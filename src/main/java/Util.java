import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

public class Util {
    public static void main(String[] args) {

    }


    static class TestUtils {
        public static List<String> readFromUrl(String source) throws IOException {
            URL sourceUrl = new URL(source);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(sourceUrl.openConnection().getInputStream()));
            return bufferedReader.lines().toList();
        }

        public static List<String> readFromFile(String file) throws IOException {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                return bufferedReader.lines().toList();
            }
        }
    }
}
