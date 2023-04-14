package dental.appointment.clinic.exceptions;


public class AppointmentNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 912326717789387972L;


    public AppointmentNotFoundException() {
        super();
    }


    public AppointmentNotFoundException(String message) {
        super(message);
    }


    public AppointmentNotFoundException(Throwable cause) {
        super(cause);
    }


    public AppointmentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
