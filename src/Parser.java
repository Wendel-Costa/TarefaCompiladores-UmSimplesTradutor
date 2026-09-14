
public class Parser {
    private final Scanner scanner;
    private Token lookahead;

    public Parser(String input) {
        scanner = new Scanner(input);
        lookahead = scanner.nextToken();
    }

    public void parse() {

        while (lookahead.getType() != TokenType.FIM) {
            statement();
        }
    }

    private void statement() {

        if (lookahead.getType() == TokenType.LET) {
            letStatement();
        } else {
            throw new RuntimeException(
                "Erro sintático: comando esperado."
            );
        }
    }

    private void letStatement() {

        match(TokenType.LET);

        String variable = lookahead.getLexeme();

        match(TokenType.IDENT);

        match(TokenType.EQUAL);

        expression();

        System.out.println("pop " + variable);

        match(TokenType.SEMICOLON);
    }

    private void expression() {

        numberOrIdentifier();

        while (
            lookahead.getType() == TokenType.PLUS ||
            lookahead.getType() == TokenType.MINUS
        ) {
            TokenType operator = lookahead.getType();

            advance();

            numberOrIdentifier();

            if (operator == TokenType.PLUS) {
                System.out.println("add");
            } else {
                System.out.println("sub");
            }
        }
    }

    private void numberOrIdentifier() {

        if (
            lookahead.getType() == TokenType.NUMBER ||
            lookahead.getType() == TokenType.IDENT
        ) {
            System.out.println(
                "push " + lookahead.getLexeme()
            );

            advance();

        } else {
            throw new RuntimeException(
                "Erro sintático: operando esperado."
            );
        }
    }

    private void match(TokenType expected) {

        if (lookahead.getType() == expected) {
            advance();
        } else {
            throw new RuntimeException(
                "Erro sintático: esperado " + expected +
                ", encontrado " + lookahead.getType()
            );
        }
    }

    private void advance() {
        lookahead = scanner.nextToken();
    }
}