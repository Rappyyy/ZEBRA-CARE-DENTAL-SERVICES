package dental.appointment.clinic.exceptions;

/**
 * Exception to throw when an attribute is invalid.
 */
public class InvalidAttributeException extends RuntimeException {

    private static final long serialVersionUID = 1234567890L;


    public InvalidAttributeException() {
        super();
    }


    public InvalidAttributeException(String message) {
        super(message);
    }


    public InvalidAttributeException(Throwable cause) {
        super(cause);
    }


    public InvalidAttributeException(String message, Throwable cause) {
        super(message, cause);
    }
}
