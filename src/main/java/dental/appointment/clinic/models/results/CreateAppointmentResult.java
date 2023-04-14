package dental.appointment.clinic.models.results;

import dental.appointment.clinic.models.AppointmentModel;

public class CreateAppointmentResult {
    private AppointmentModel appointment;

    public CreateAppointmentResult(Builder builder) {
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

        public Builder withAppointment(AppointmentModel appointment) {
            this.appointment = appointment;
            return this;
        }

        public CreateAppointmentResult build() {
            return new CreateAppointmentResult(this);
        }
    }
}
