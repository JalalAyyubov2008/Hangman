public class HangmanChecker {
    private final String word;
    private final HangmanStage hangman;

    public HangmanChecker(String word) {
        this.word = word;
        this.hangman = new HangmanStage(word);
    }

    public boolean checkIfAppropriate(String letter) {
        return letter != null && letter.matches("[а-яА-ЯёЁ]");
    }

    public boolean checkIfUsed(String letter) {
        if(!hangman.getUsedLetters().contains(letter.charAt(0))) {
            hangman.useLetter(letter);
            return false;
        }
        System.out.println("You have already used the letter, try another one");
        return true;
    }

    public StringBuilder checkLetter(String letter) {
        if (!word.contains(letter) && !hangman.getMistakes().contains(letter)) {
            hangman.addIfMistake(letter);
            hangman.showMistakes();
            return hangman.showWordStage();
        }

        char guessedChar = letter.charAt(0);
        for (int i = 0; i < word.length(); i++) {
            if (guessedChar == word.charAt(i)) {
                openLetter(i, word.charAt(i));
            }
        }
        hangman.showMistakes();
        return hangman.showWordStage();
    }

    public void openLetter(int index, char symbol) {
        hangman.showWordStage().setCharAt(index, symbol);
        hangman.setWordStage(hangman.showWordStage());
    }
}
