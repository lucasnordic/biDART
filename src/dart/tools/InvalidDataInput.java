package dart.tools;

public class InvalidDataInput extends RuntimeException {
    private String message;


    public InvalidDataInput(String message) throws RuntimeException {
        super(message);
    }

}
