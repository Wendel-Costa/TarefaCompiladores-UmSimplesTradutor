import java.util.HashMap;
import java.util.Map;

public class Scanner {
    private final String input;
    private int current;

    private static final Map<String, TokenType> KEYWORDS = new HashMap<>();

    static {
        KEYWORDS.put("let", TokenType.LET);
    }

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

        return new Token(
            TokenType.NUMBER,
            input.substring(start, current)
        );
    }

    private boolean isAlpha(char c) {
        return Character.isLetter(c) || c == '_';
    }

    private boolean isAlphaNumeric(char c) {
        return isAlpha(c) || Character.isDigit(c);
    }

    private Token identifier() {

        int start = current;

        while (isAlphaNumeric(peek())) {
            advance();
        }

        String lexeme = input.substring(start, current);

        TokenType type =
            KEYWORDS.getOrDefault(lexeme, TokenType.IDENT);

        return new Token(type, lexeme);
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

        if (isAlpha(c)) {
            return identifier();
        }

        advance();

        switch (c) {
            case '+':
                return new Token(TokenType.PLUS, "+");

            case '-':
                return new Token(TokenType.MINUS, "-");

            case '=':
                return new Token(TokenType.EQUAL, "=");

            case ';':
                return new Token(TokenType.SEMICOLON, ";");

            default:
                throw new RuntimeException(
                    "Erro léxico: caractere inesperado '" + c + "'."
                );
        }
    }
}