import java.util.List;

public class HangmanRenderer {
    private final String[] STAGES = {
            """
           +---+
           |   |
               |
               |
               |
               |
         =========""",

            """
           +---+
           |   |
           O   |
               |
               |
               |
         =========""",

            """
           +---+
           |   |
           O   |
           |   |
               |
               |
         =========""",

            """
           +---+
           |   |
           O   |
          /|   |
               |
               |
         =========""",

            """
           +---+
           |   |
           O   |
          /|\\  |
               |
               |
         =========""",

            """
           +---+
           |   |
           O   |
          /|\\  |
          /    |
               |
         =========""",

            """
           +---+
           |   |
           O   |
          /|\\  |
          / \\  |
               |
         ========="""
    };

    public void renderStage(int attempts) {
        System.out.print(STAGES[attempts]);
    }
}
