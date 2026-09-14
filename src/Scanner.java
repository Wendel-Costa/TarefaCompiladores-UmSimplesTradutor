
public class Scanner {
    private final String input;
    private int current;

    public Scanner(String input) {
        this.input = input;
        this.current = 0;
    }

    private char peek() {
        if (current < input.length()) {
            return input.charAt(current);
        }

        return '\0';
    }

    private void advance() {
        if (current < input.length()) {
            current++;
        }
    }

    public char next() {
        char currentChar = peek();

        if (currentChar == '\0') {
            return '\0';
        }

        advance();
        return currentChar;
    }
}