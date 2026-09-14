
public class Main {
    public static void main(String[] args) {
        String input = "67+20-34+1";

        Parser parser = new Parser(input);
        parser.parse();
    }
}