package dental.appointment.clinic.converters;

import dental.appointment.clinic.dynamodb.models.Appointment;
import dental.appointment.clinic.models.AppointmentModel;

import java.util.ArrayList;
import java.util.List;

public class AppointmentConverter {

    public AppointmentConverter() {
    }

    public AppointmentModel convertToAppointmentModel(Appointment appointment) {
        return AppointmentModel.builder()
                .withAppointmentId(appointment.getAppointmentId())
                .withStartTime(appointment.getStartTime())
                .withEndTime(appointment.getEndTime())
                .withPatientId(appointment.getPatientId())
                .withPatientName(appointment.getPatientName())
                .withDentistName(appointment.getDentistName())
                .withContactInfo(appointment.getContactInfo())
                .withAddress(appointment.getAddress())
                .withDescription(appointment.getDescription())
                .withService(appointment.getService())
                .build();
    }

}
