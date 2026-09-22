import java.util.Scanner;

public class HangmanOptions {
    private final Scanner scanner = new Scanner(System.in);

    public String chooseOption() {
        System.out.println("1 - play | 2 - exit");
        String option;
        while (true) {
            option = scanner.next();
            if (option.equals("2")) {
                HangmanStartLeave.leave();
                return null;
            } else if(option.equals("1")) return HangmanStartLeave.start();
            else System.out.println("Enter a correct option");
        }
    }
}
