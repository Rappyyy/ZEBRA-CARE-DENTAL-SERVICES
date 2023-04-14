package dental.appointment.clinic.Activity;

import com.amazon.ata.aws.dynamodb.DynamoDbClientProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import dental.appointment.clinic.converters.AppointmentConverter;
import dental.appointment.clinic.dynamodb.AppointmentDao;
import dental.appointment.clinic.dynamodb.models.Appointment;
import dental.appointment.clinic.exceptions.AppointmentNotFoundException;
import dental.appointment.clinic.models.AppointmentModel;
import dental.appointment.clinic.models.requests.UpdateAppointmentRequest;
import dental.appointment.clinic.models.results.UpdateAppointmentResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.time.LocalDateTime;

public class UpdateAppointmentActivity implements RequestHandler<UpdateAppointmentRequest, UpdateAppointmentResult> {
    private final Logger log = LogManager.getLogger();
    private final AppointmentDao appointmentDao;

    @Inject
    public UpdateAppointmentActivity(AppointmentDao appointmentDao) {
        this.appointmentDao = appointmentDao;
    }

    public UpdateAppointmentActivity() {
        this.appointmentDao = new AppointmentDao(new DynamoDBMapper(DynamoDbClientProvider.getDynamoDBClient(Regions.US_WEST_2)));
    }

    @Override
    public UpdateAppointmentResult handleRequest(final UpdateAppointmentRequest updateAppointmentRequest, Context context) {
        log.info("Received UpdateAppointmentRequest {}", updateAppointmentRequest);

        String appointmentId = updateAppointmentRequest.getId();
        String patientName = updateAppointmentRequest.getPatientName();
        String dentistName = updateAppointmentRequest.getDentistName();


        Appointment appointment = appointmentDao.getAppointment(appointmentId);

        if (appointment == null){
            throw new AppointmentNotFoundException();
        }

        appointment.setPatientName(patientName);
        appointment.setDentistName(dentistName);


        if (updateAppointmentRequest.getStartTime() != null) {
            String startTime = updateAppointmentRequest.getStartTime();
            appointment.setStartTime(LocalDateTime.parse(startTime));
        }

        if (updateAppointmentRequest.getEndTime() != null) {
            String endTime = updateAppointmentRequest.getEndTime();
            appointment.setEndTime(LocalDateTime.parse(endTime));
        }

        if (updateAppointmentRequest.getDescription() != null) {
            String description = updateAppointmentRequest.getDescription();
            appointment.setDescription(description);
        }

        if (updateAppointmentRequest.getService() != null) {
            String service = updateAppointmentRequest.getService();
            appointment.setService(service);
        }

        if (updateAppointmentRequest.getContactInfo() != null) {
            String contactInfo = updateAppointmentRequest.getContactInfo();
            appointment.setContactInfo(contactInfo);
        }

        if (updateAppointmentRequest.getAddress() != null) {
            String address = updateAppointmentRequest.getAddress();
            appointment.setAddress(address);
        }



        Appointment updatedAppointment = appointmentDao.saveAppointment(appointment);

        AppointmentModel appointmentModel = new AppointmentConverter().convertToAppointmentModel(updatedAppointment);

        return UpdateAppointmentResult.builder()
                .withAppointment(appointmentModel)
                .build();
    }
}
