import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Interpreter {

    private final Deque<Integer> stack = new ArrayDeque<>();

    private final Map<String, Integer> variables =
        new HashMap<>();

    public void execute(List<Command> commands) {

        for (Command command : commands) {

            switch (command.getType()) {

                case PUSH:

                    String value = command.getArgument();

                    if (variables.containsKey(value)) {
                        stack.push(variables.get(value));
                    } else {
                        stack.push(Integer.parseInt(value));
                    }

                    break;

                case POP:

                    int result = pop();

                    variables.put(
                        command.getArgument(),
                        result
                    );

                    break;

                case ADD:

                    binaryOperation((a, b) -> a + b);

                    break;

                case SUB:

                    binaryOperation((a, b) -> a - b);

                    break;

                case PRINT:

                    System.out.println(pop());

                    break;
            }
        }
    }

    private int pop() {

        if (stack.isEmpty()) {
            throw new IllegalStateException(
                "Erro: pilha vazia."
            );
        }

        return stack.pop();
    }

    private void binaryOperation(Operation operation) {

        int b = pop();
        int a = pop();

        stack.push(operation.apply(a, b));
    }

    @FunctionalInterface
    private interface Operation {

        int apply(int a, int b);
    }
}