import java.util.ArrayList;
import java.util.List;

public class Parser {
    private final Scanner scanner;
    private Token lookahead;

    private final List<Command> commands =
        new ArrayList<>();

    public Parser(String input) {
        scanner = new Scanner(input);
        lookahead = scanner.nextToken();
    }

    public List<Command> parse() {

        while (lookahead.getType() != TokenType.FIM) {
            statement();
        }

        return commands;
    }

    private void statement() {

        if (lookahead.getType() == TokenType.LET) {
            letStatement();

        } else if (lookahead.getType() == TokenType.PRINT) {
            printStatement();

        } else {
            throw new RuntimeException(
                "Erro sintático: comando esperado."
            );
        }
    }

    private void letStatement() {

        match(TokenType.LET);

        String variable =
            lookahead.getLexeme();

        match(TokenType.IDENT);

        match(TokenType.EQUAL);

        expression();

        commands.add(
            Command.pop(variable)
        );

        match(TokenType.SEMICOLON);
    }

    private void printStatement() {

        match(TokenType.PRINT);

        expression();

        commands.add(
            Command.print()
        );

        match(TokenType.SEMICOLON);
    }

    private void expression() {

        term();

        while (
            lookahead.getType() == TokenType.PLUS ||
            lookahead.getType() == TokenType.MINUS
        ) {

            TokenType operator =
                lookahead.getType();

            advance();

            term();

            if (operator == TokenType.PLUS) {
                commands.add(Command.add());
            } else {
                commands.add(Command.sub());
            }
        }
    }

    private void term() {

        factor();

        while (
            lookahead.getType() == TokenType.STAR ||
            lookahead.getType() == TokenType.SLASH
        ) {

            TokenType operator =
                lookahead.getType();

            advance();

            factor();

            if (operator == TokenType.STAR) {
                commands.add(Command.mul());
            } else {
                commands.add(Command.div());
            }
        }
    }

    private void factor() {

        if (
            lookahead.getType() == TokenType.NUMBER ||
            lookahead.getType() == TokenType.IDENT
        ) {

            commands.add(
                Command.push(
                    lookahead.getLexeme()
                )
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
                "Erro sintático: esperado "
                + expected
                + ", encontrado "
                + lookahead.getType()
            );
        }
    }

    private void advance() {
        lookahead = scanner.nextToken();
    }
}