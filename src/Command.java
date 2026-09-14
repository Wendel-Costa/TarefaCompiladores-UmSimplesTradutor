
public class Command {

    public enum Type {
        PUSH,
        POP,
        ADD,
        SUB,
        PRINT
    }

    private final Type type;
    private final String argument;

    private Command(Type type, String argument) {
        this.type = type;
        this.argument = argument;
    }

    public static Command push(String value) {
        return new Command(Type.PUSH, value);
    }

    public static Command pop(String variable) {
        return new Command(Type.POP, variable);
    }

    public static Command add() {
        return new Command(Type.ADD, null);
    }

    public static Command sub() {
        return new Command(Type.SUB, null);
    }

    public static Command print() {
        return new Command(Type.PRINT, null);
    }

    public Type getType() {
        return type;
    }

    public String getArgument() {
        return argument;
    }

    @Override
    public String toString() {

        if (argument == null) {
            return type.name().toLowerCase();
        }

        return type.name().toLowerCase()
            + " " + argument;
    }
}