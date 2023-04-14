package dental.appointment.clinic.util;
import java.util.UUID;


public final class PatientsUtil {
    // package private for testing
    // do not instantiate
    private PatientsUtil() {}

    public static String generatePatientId() {
        return UUID.randomUUID().toString();
    }
}
