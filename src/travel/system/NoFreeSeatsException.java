package travel.system;

public class NoFreeSeatsException extends RuntimeException{
    public NoFreeSeatsException(String message) {
        super(message);
    }
}
