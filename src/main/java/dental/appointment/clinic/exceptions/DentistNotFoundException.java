package dental.appointment.clinic.exceptions;

public class DentistNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1411587415941879115L;

    public DentistNotFoundException() {
        super();
    }
    public DentistNotFoundException(String message) {
        super(message);
    }

    public DentistNotFoundException(Throwable cause) {
        super(cause);
    }

    public DentistNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
