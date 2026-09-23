public class HangmanChecker {
    private final String word;
    private final HangmanStage hangmanStage;

    public HangmanChecker(String word, HangmanStage hangmanStage) {
        this.word = word;
        this.hangmanStage = hangmanStage;
    }

    public boolean checkIfAppropriate(String letter) {
        if (!letter.matches("[а-яА-ЯёЁ]")) {
            System.out.println("\nEnter an allowed letter (а-я, А-Я)");
            return false;
        }
        return true;
    }

    public boolean checkIfFinalAttempt() {
        if (hangmanStage.getAttempts() == 0) {
            System.out.println("\nYou have used up all your attempts");
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            System.out.println("THE WORD - " + word);
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            return true;
        }
        return false;
    }

    public boolean checkIfCompleted() {
        return !hangmanStage.showWordStage().toString().contains("_");
    }

    public boolean addIfNotUsed(String letter) {
        if(!hangmanStage.getUsedLetters().contains(letter.charAt(0))) {
            hangmanStage.useLetter(letter);
            return false;
        }
        System.out.println("\nYou have already used the letter, try another one");
        return true;
    }

    public boolean addIfMistake(String letter) {
        if(!word.contains(letter) && !hangmanStage.getMistakes().contains(letter)) {
            hangmanStage.getMistakes().add(letter);
            return true;
        }
        return false;
    }

    public void openLetter(String letter) {
        char charLetter = letter.charAt(0);
        for (int i = 0; i < word.length(); i++) {
            if (charLetter == word.charAt(i)) {
                hangmanStage.showWordStage().setCharAt(i, charLetter);
                hangmanStage.setWordStage(hangmanStage.showWordStage());
            }
        }
    }
}
