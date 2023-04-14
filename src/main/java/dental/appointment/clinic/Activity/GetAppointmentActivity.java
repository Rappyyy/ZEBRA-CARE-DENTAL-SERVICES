package dental.appointment.clinic.Activity;

import com.amazon.ata.aws.dynamodb.DynamoDbClientProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import dental.appointment.clinic.converters.AppointmentConverter;
import dental.appointment.clinic.dynamodb.models.Appointment;
import dental.appointment.clinic.dynamodb.AppointmentDao;
import dental.appointment.clinic.exceptions.AppointmentNotFoundException;
import dental.appointment.clinic.models.AppointmentModel;
import dental.appointment.clinic.models.requests.GetAppointmentRequest;
import dental.appointment.clinic.models.results.GetAppointmentResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;


public class GetAppointmentActivity implements RequestHandler<GetAppointmentRequest, GetAppointmentResult> {
    private final Logger log = LogManager.getLogger();
    private final AppointmentDao appointmentDao;

    @Inject
    public GetAppointmentActivity(AppointmentDao appointmentDao) {
        this.appointmentDao = appointmentDao;
    }

    public GetAppointmentActivity() {
        this.appointmentDao = new AppointmentDao(new DynamoDBMapper(DynamoDbClientProvider.getDynamoDBClient(Regions.US_WEST_2)));
    }

    @Override
    public GetAppointmentResult handleRequest(final GetAppointmentRequest getAppointmentRequest, Context context) {
        log.info("Received GetAppointmentRequest {}", getAppointmentRequest);
        String requestedId = getAppointmentRequest.getId();

        if (requestedId == null) {
            throw new RuntimeException("Requested id is null");
        }

        Appointment appointment = appointmentDao.getAppointment(requestedId);

        if (appointment == null){
            throw new AppointmentNotFoundException();
        }

        AppointmentModel appointmentModel = new AppointmentConverter().convertToAppointmentModel(appointment);

        return GetAppointmentResult.builder()
                .withAppointment(appointmentModel)
                .build();
    }
}