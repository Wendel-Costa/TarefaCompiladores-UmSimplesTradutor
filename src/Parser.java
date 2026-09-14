
public class Parser {
    private final Scanner scanner;
    private Token lookahead;

    public Parser(String input) {
        scanner = new Scanner(input);
        lookahead = scanner.nextToken();
    }

    public void parse() {
        expression();

        if (lookahead.getType() != TokenType.FIM) {
            throw new RuntimeException("Erro sintático.");
        }
    }

    private void expression() {
        number();

        while (
            lookahead.getType() == TokenType.PLUS ||
            lookahead.getType() == TokenType.MINUS
        ) {
            TokenType operator = lookahead.getType();

            advance();

            number();

            if (operator == TokenType.PLUS) {
                System.out.println("add");
            } else {
                System.out.println("sub");
            }
        }
    }

    private void number() {

        if (lookahead.getType() == TokenType.NUMBER) {
            System.out.println("push " + lookahead.getLexeme());
            advance();
        } else {
            throw new RuntimeException("Erro sintático: número esperado.");
        }
    }

    private void advance() {
        lookahead = scanner.nextToken();
    }
}