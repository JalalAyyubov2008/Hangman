import java.util.ArrayList;
import java.util.List;

public class HangmanStage {
    private StringBuilder wordStage;
    private final List<String> mistakes;
    private final String word;
    public HangmanStage(String word) {
        this.word = word;
        this.wordStage = new StringBuilder("_".repeat(word.length()));
        this.mistakes = new ArrayList<>();
    }

    public StringBuilder showWordStage() {
        return wordStage;
    }

    public void setWordStage(StringBuilder wordStage) {
        this.wordStage = wordStage;
    }

    public boolean checkIfCompleted(StringBuilder processedWord) {
        return processedWord.toString().equals(word);
    }

    public void addIfMistake(String letter) {
        mistakes.add(letter);
    }

    public void showMistakes() {
        System.out.print("Mistakes: ");
        mistakes.forEach(m -> System.out.print(m + " "));
        System.out.println();
    }

    public List<String> getMistakes() {
        return mistakes;
    }
}

