
public class Parser {
    private final byte[] input;
    private int current;

    public Parser(byte[] input) {
        this.input = input;
        this.current = 0;
    }

    public void parse() {
        expr();

        if (peek() != '\0') {
            throw new RuntimeException("Erro sintático: entrada inesperada.");
        }
    }

    private char peek() {
        if (current < input.length) {
            return (char) input[current];
        }

        return '\0';
    }

    private void match(char c) {
        if (c == peek()) {
            current++;
        } else {
            throw new RuntimeException(
                "Erro sintático: esperado '" + c +
                "', encontrado '" + peek() + "'."
            );
        }
    }

    private void expr() {
        digit();
        oper();
    }

    private void oper() {
        if (peek() == '+') {
            match('+');
            digit();
            System.out.println("add");
            oper();

        } else if (peek() == '-') {
            match('-');
            digit();
            System.out.println("sub");
            oper();
        }
    }

    private void digit() {
        if (Character.isDigit(peek())) {
            System.out.println("push " + peek());
            match(peek());
        } else {
            throw new RuntimeException("Erro sintático: esperado dígito.");
        }
    }
}