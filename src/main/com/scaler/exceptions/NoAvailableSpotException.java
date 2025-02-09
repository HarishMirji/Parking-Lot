package main.com.scaler.exceptions;

public class NoAvailableSpotException extends Exception {
    public NoAvailableSpotException(String message) {
        super(message);
    }
}
