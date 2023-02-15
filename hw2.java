import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class hw2 {
    public static void main(String[] args) {
        Path path = Path.of("JavaHomeWork2", "JavaHomeWork2", "temp.txt");
        Path directoryPath = Path.of("JavaHomeWork2", "JavaHomeWork2");
        String text = "TEST";
        int repeat = 100;
        
        String fileString = getString(text, repeat);

        if (!Files.exists(path)) {
            try {
                Files.createDirectories(directoryPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
            createFile(path);
        }
        fillFile(path, fileString);
    }

    public static void createFile(Path path) {
        try {
            Files.createFile(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void fillFile(Path path, String text) {
        try {
            Files.writeString(path, text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getString(String text, int repeat) {
        StringBuilder newString = new StringBuilder();

        for (int i = 0; i < repeat; i++) {
            newString.append(text + "\n");
        }
        return newString.toString();
    }
}