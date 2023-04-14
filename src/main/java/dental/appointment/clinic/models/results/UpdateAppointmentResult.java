package dental.appointment.clinic.models.results;

import dental.appointment.clinic.models.AppointmentModel;

public class UpdateAppointmentResult {
    private AppointmentModel appointment;

    public UpdateAppointmentResult(Builder builder) {
        this.appointment = builder.appointment;
    }

    public AppointmentModel getAppointment() {
        return appointment;
    }

    public void setAppointment(AppointmentModel appointment) {
        this.appointment = appointment;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private AppointmentModel appointment;

        public Builder withAppointment(AppointmentModel appointmentToUse) {
            this.appointment = appointmentToUse;
            return this;
        }

        public UpdateAppointmentResult build() {
            return new UpdateAppointmentResult(this);
        }
    }
}
