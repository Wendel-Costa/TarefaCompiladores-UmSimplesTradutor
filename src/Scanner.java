
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

    private void skipWhitespace() {
        while (Character.isWhitespace(peek())) {
            advance();
        }
    }

    private Token number() {

        int start = current;

        while (Character.isDigit(peek())) {
            advance();
        }

        String lexeme = input.substring(start, current);

        return new Token(TokenType.NUMBER, lexeme);
    }

    public Token nextToken() {

        skipWhitespace();

        char c = peek();

        if (c == '\0') {
            return new Token(TokenType.FIM, "");
        }

        if (Character.isDigit(c)) {
            return number();
        }

        advance();

        switch (c) {
            case '+':
                return new Token(TokenType.PLUS, "+");

            case '-':
                return new Token(TokenType.MINUS, "-");

            default:
                throw new RuntimeException(
                    "Erro léxico: caractere inesperado '" + c + "'."
                );
        }
    }
}