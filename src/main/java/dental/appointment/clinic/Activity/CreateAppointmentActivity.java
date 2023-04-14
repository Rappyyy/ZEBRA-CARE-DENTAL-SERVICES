package dental.appointment.clinic.Activity;

import com.amazon.ata.aws.dynamodb.DynamoDbClientProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import dental.appointment.clinic.converters.AppointmentConverter;
import dental.appointment.clinic.dynamodb.models.Appointment;
import dental.appointment.clinic.dynamodb.AppointmentDao;

import dental.appointment.clinic.models.AppointmentModel;
import dental.appointment.clinic.models.requests.CreateAppointmentRequest;
import dental.appointment.clinic.models.results.CreateAppointmentResult;
import dental.appointment.clinic.util.AppointmentUtils;
import dental.appointment.clinic.util.PatientsUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.time.LocalDateTime;


public class CreateAppointmentActivity implements RequestHandler<CreateAppointmentRequest, CreateAppointmentResult> {
    private final Logger log = LogManager.getLogger();

    private final AppointmentDao appointmentDao;


    @Inject
    public CreateAppointmentActivity(AppointmentDao appointmentDao) {
        this.appointmentDao = appointmentDao;
    }

    public CreateAppointmentActivity() {
        this.appointmentDao = new AppointmentDao(new DynamoDBMapper(DynamoDbClientProvider.getDynamoDBClient(Regions.US_WEST_2)));
    }

    @Override
    public CreateAppointmentResult handleRequest(final CreateAppointmentRequest createAppointmentRequest, Context context) {
        log.info("Received CreateAppointmentRequest {}", createAppointmentRequest);

        String patientName = createAppointmentRequest.getPatientName();
        String dentistName = createAppointmentRequest.getDentistName();
        String appointmentId = AppointmentUtils.generateAppointmentId();
        LocalDateTime startTime = createAppointmentRequest.getStartTime();
        LocalDateTime endTime = createAppointmentRequest.getEndTime();
        String description = createAppointmentRequest.getDescription();
        String service = createAppointmentRequest.getService();
        String contactInfo = createAppointmentRequest.getContactInfo();
        String address = createAppointmentRequest.getAddress();

        Appointment appointment = new Appointment();
        appointment.setAppointmentId(appointmentId);
        appointment.setStartTime(startTime);
        appointment.setEndTime(endTime);
        appointment.setPatientId(PatientsUtil.generatePatientId());
        appointment.setPatientName(patientName);
        appointment.setContactInfo(contactInfo);
        appointment.setAddress(address);
        appointment.setDentistName(dentistName);
        appointment.setDescription(description);
        appointment.setService(service);

        appointmentDao.saveAppointment(appointment);

        AppointmentModel appointmentModel = new AppointmentConverter().convertToAppointmentModel(appointment);
        return CreateAppointmentResult.builder()
                .withAppointment(appointmentModel)
                .build();

    }
}
