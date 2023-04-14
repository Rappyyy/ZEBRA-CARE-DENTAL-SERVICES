package dental.appointment.clinic.exceptions;

public class PatientNotFoundException extends RuntimeException{

    private static final long serialVersionUID = -5561751751852181747L;


    public PatientNotFoundException() {
        super();
    }


    public PatientNotFoundException(String message) {
        super(message);
    }


    public PatientNotFoundException(Throwable cause) {
        super(cause);
    }


    public PatientNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
