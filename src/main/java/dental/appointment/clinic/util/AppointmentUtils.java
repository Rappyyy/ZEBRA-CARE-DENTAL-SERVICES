package dental.appointment.clinic.util;


import java.util.UUID;
import java.util.regex.Pattern;

public final class AppointmentUtils {

    // do not instantiate
    private AppointmentUtils() {}

    public static String generateAppointmentId() {
//        return RandomStringUtils.randomAlphanumeric(PLAYLIST_ID_LENGTH);
        return UUID.randomUUID().toString();
    }
}
