package dental.appointment.clinic.dynamodb.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dental.appointment.clinic.exceptions.PatientNotFoundException;

import javax.inject.Inject;

/**
 * Accesses data for a patient using {@link Patient} to represent the model in DynamoDB.
 */
public class PatientDao {

    private final DynamoDBMapper dynamoDbMapper;

    @Inject
    public PatientDao(DynamoDBMapper dynamoDbMapper) {
        this.dynamoDbMapper = dynamoDbMapper;
    }

    public Patient getPatient(String id) {
        Patient patient = this.dynamoDbMapper.load(Patient.class, id);

        if (patient == null) {
            throw new PatientNotFoundException("Could not find patient with id " + id);
        }

        return patient;
    }


    public Patient savePatient(Patient patient) {
        try {
            dynamoDbMapper.save(patient);
        } catch (Exception e) {
            System.out.println(e);
        }
        return patient;
    }

}
