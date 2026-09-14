
public class Main {
    public static void main(String[] args) {
        String input = "6+7-2+1";

        Parser parser = new Parser(input.getBytes());
        parser.parse();
    }
}