
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

    public Token nextToken() {
        char c = peek();

        if (c == '\0') {
            return new Token(TokenType.FIM, "");
        }

        advance();

        switch (c) {
            case '+':
                return new Token(TokenType.PLUS, "+");

            case '-':
                return new Token(TokenType.MINUS, "-");

            default:
                if (Character.isDigit(c)) {
                    return new Token(TokenType.EOF, String.valueOf(c));
                }

                throw new RuntimeException(
                    "Erro léxico: caractere inesperado '" + c + "'."
                );
        }
    }
}