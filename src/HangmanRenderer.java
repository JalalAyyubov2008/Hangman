public class HangmanRenderer {
    private final String[] STAGES = {
            """
           +---+
           |   |
               | 0 attempts
               | 
               |
               |
         =========""",

            """
           +---+
           |   |
           O   | 1 attempts
               | 
               |
               |
         =========""",

            """
           +---+
           |   |
           O   | 2 attempts
           |   | 
               |
               |
         =========""",

            """
           +---+
           |   |
           O   | 3 attempts
          /|   | 
               |
               |
         =========""",

            """
           +---+
           |   |
           O   | 4 attempts
          /|\\  |
               |
               |
         =========""",

            """
           +---+
           |   |
           O   | 5 attempts
          /|\\  |
          /    |
               |
         =========""",

            """
           +---+
           |   |
           O   | 6 attempts
          /|\\  |
          / \\  |
               |
         ========="""
    };

    public void renderStage(int attempts) {
        System.out.println("\n" + STAGES[attempts]);
    }
}
