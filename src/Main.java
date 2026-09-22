public class Main {
    public static void main(String[] args) {
        HangmanOptions hangmanOptions = new HangmanOptions();
        String randomWord = hangmanOptions.chooseOption();
        if (randomWord == null) return;
        HangmanStage hangmanStage = new HangmanStage(randomWord);
        HangmanChecker hangmanChecker = new HangmanChecker(randomWord, hangmanStage);
        HangmanRunner hangmanRunner = new HangmanRunner(hangmanStage, hangmanChecker);

        hangmanRunner.run();
    }
}
