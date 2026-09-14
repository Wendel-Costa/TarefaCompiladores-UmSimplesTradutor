
public class Parser {
    private final Scanner scanner;
    private char lookahead;

    public Parser(String input) {
        this.scanner = new Scanner(input);
        this.lookahead = scanner.next();
    }

    public void parse() {
        expr();

        if (lookahead != '\0') {
            throw new RuntimeException("Erro sintático.");
        }
    }

    private void match(char c) {
        if (lookahead == c) {
            lookahead = scanner.next();
        } else {
            throw new RuntimeException(
                "Erro sintático: esperado '" + c +
                "', encontrado '" + lookahead + "'."
            );
        }
    }

    private void expr() {
        digit();
        oper();
    }

    private void oper() {
        if (lookahead == '+') {
            match('+');
            digit();
            System.out.println("add");
            oper();

        } else if (lookahead == '-') {
            match('-');
            digit();
            System.out.println("sub");
            oper();
        }
    }

    private void digit() {
        if (Character.isDigit(lookahead)) {
            System.out.println("push " + lookahead);
            match(lookahead);
        } else {
            throw new RuntimeException("Erro sintático.");
        }
    }
}