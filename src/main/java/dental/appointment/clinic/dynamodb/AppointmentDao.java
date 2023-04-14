package dental.appointment.clinic.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dental.appointment.clinic.dynamodb.models.Appointment;
import dental.appointment.clinic.dynamodb.models.Patient;
import dental.appointment.clinic.exceptions.AppointmentNotFoundException;
import dental.appointment.clinic.exceptions.PatientNotFoundException;

import javax.inject.Inject;

public class AppointmentDao {

    private final DynamoDBMapper dynamoDbMapper;


    @Inject
    public AppointmentDao(DynamoDBMapper dynamoDbMapper) {
        this.dynamoDbMapper = dynamoDbMapper;
    }

    public Appointment getAppointment(String id) {
        Appointment appointment = this.dynamoDbMapper.load(Appointment.class, id);

        if (appointment == null) {
            throw new AppointmentNotFoundException("Could not find appointment with id " + id);
        }

        return appointment;
    }
    public Patient getPatientId(String id) {
        Patient patient = this.dynamoDbMapper.load(Patient.class, id);

        if (patient == null) {
            throw new PatientNotFoundException("Could not find patient with id " + id);
        }

        return patient;
    }


    public Appointment saveAppointment(Appointment appointment) {
        try {
            dynamoDbMapper.save(appointment);
        } catch (Exception e) {
            System.out.println(e);
        }
        return appointment;
    }

}
