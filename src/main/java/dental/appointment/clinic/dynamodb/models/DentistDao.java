package dental.appointment.clinic.dynamodb.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dental.appointment.clinic.dynamodb.models.Dentist;
import dental.appointment.clinic.exceptions.DentistNotFoundException;

import javax.inject.Inject;

/**
 * Accesses data for a dentist using {@link Dentist} to represent the model in DynamoDB.
 */
public class DentistDao {

    private final DynamoDBMapper dynamoDbMapper;

    @Inject
    public DentistDao(DynamoDBMapper dynamoDbMapper) {
        this.dynamoDbMapper = dynamoDbMapper;
    }

    public Dentist getDentist(String id) {
        Dentist dentist = this.dynamoDbMapper.load(Dentist.class, id);

        if (dentist == null) {
            throw new DentistNotFoundException("Could not find dentist with id " + id);
        }

        return dentist;
    }


    public Dentist saveDentist(Dentist dentist) {
        try {
            dynamoDbMapper.save(dentist);
        } catch (Exception e) {
            System.out.println(e);
        }
        return dentist;
    }

}
