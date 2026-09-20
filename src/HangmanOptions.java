import java.util.Scanner;

public class HangmanOptions {
    private final Scanner scanner = new Scanner(System.in);
    public String chooseOption() {
        String option;
        String randomWord = null;
        System.out.println("Press 1 to play\nPress 2 to exit");
        while (true) {
            option = scanner.next();
            System.out.println();
            if(option.equals("1")) {
                randomWord = HangmanStartLeave.start();
                break;
            } else if (option.equals("2")) {
                HangmanStartLeave.leave();
                break;
            } else {
                System.out.println("Enter a correct option");
            }
        }
        return randomWord;
    }
}
