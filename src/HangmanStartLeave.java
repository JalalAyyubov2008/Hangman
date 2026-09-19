import java.util.List;
import java.util.Random;

public class HangmanStartLeave {
    public static String start() {
        List<String> words = HangmanWordLoader.wordLoader("src/words.txt");
        if (words.isEmpty()) {
            System.out.println("Error: the file is empty.");
            return null;
        }
        return words.get(new Random().nextInt(words.size()));
    }

    public static void leave() {
        System.out.println("Exiting...");
    }
}
