import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HangmanWordLoader {
    public static ArrayList<String> wordLoader(String fileName) {
        ArrayList<String> words = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) words.add(line.trim());
            }
        } catch (IOException e) {
            System.err.println("An error occurred whilst retrieving the word" + fileName + ": " + e.getMessage());
        }
        return words;
    }
}
