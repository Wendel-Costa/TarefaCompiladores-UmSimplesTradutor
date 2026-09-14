import java.util.List;

public class Main {
    public static void main(String[] args) {
        String input = "let a = 42 + 5;" + "print a + 6;";

        Parser parser = new Parser(input);

        List<Command> commands = parser.parse();

        for (Command command : commands) {
            System.out.println(command);
        }
    }
}