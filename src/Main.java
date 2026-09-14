import java.util.List;

public class Main {
    public static void main(String[] args) {
        String input = "let a = 42 + 5 * 6 / 2;" + "print a + 6;";

        Parser parser = new Parser(input);

        List<Command> commands = parser.parse();

        System.out.println("=== TRADUÇÃO ===");

        for (Command command : commands) {
            System.out.println(command);
        }

        System.out.println("=== EXECUÇÃO ===");

        Interpreter interpreter =
            new Interpreter();

        interpreter.execute(commands);
    }
}