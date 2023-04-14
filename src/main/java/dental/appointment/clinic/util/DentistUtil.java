package dental.appointment.clinic.util;

import org.apache.commons.lang3.StringUtils;

import java.util.UUID;
import java.util.regex.Pattern;

public class DentistUtil {
    // package private for testing

    // do not instantiate
    private DentistUtil() {}


    public static String generateDentistId() {
        return UUID.randomUUID().toString();
    }

}
