package dental.appointment.clinic.models;

import dental.appointment.clinic.dynamodb.models.Appointment;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class AppointmentModel {
    private String appointmentId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String patientName;
    private String patientId;
    private String dentistName;
    private String description;
    private String service;
    private String address;
    private String contactInfo;




    public AppointmentModel() {
    }

    public AppointmentModel(String appointmentId, LocalDateTime startTime, LocalDateTime endTime, String patientName,
                            String patientId, String dentistName, String description, String service,
                            String contactInfo, String address) {
        this.appointmentId = appointmentId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.patientName = patientName;
        this.patientId = patientId;
        this.dentistName = dentistName;
        this.description = description;
        this.service = service;
        this.contactInfo = contactInfo;
        this.address = address;
    }

    private AppointmentModel(Builder builder) {
        this.appointmentId = builder.appointmentId;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.patientName = builder.patientName;
        this.patientId = builder.patientId;
        this.dentistName = builder.dentistName;
        this.description = builder.description;
        this.service = builder.service;
        this.contactInfo = builder.contactInfo;
        this.address = builder.address;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getDentistName() {
        return dentistName;
    }

    public String getDescription() {
        return description;
    }

    public String getService() {
        return service;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AppointmentModel)) return false;
        AppointmentModel that = (AppointmentModel) o;
        return Objects.equals(getAppointmentId(), that.getAppointmentId()) && Objects.equals(getStartTime(),
                that.getStartTime()) && Objects.equals(getEndTime(), that.getEndTime()) && Objects.equals(getPatientName(),
                that.getPatientName()) && Objects.equals(getPatientId(), that.getPatientId()) && Objects.equals(getDentistName(),
                that.getDentistName()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getService(),
                that.getService()) && Objects.equals(getContactInfo(), that.getContactInfo()) && Objects.equals(getAddress(),
                that.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAppointmentId(), getStartTime(), getEndTime(), getPatientName(), getPatientId(),
                getDentistName(), getDescription(), getService(), getContactInfo(), getAddress());
    }

    @Override
    public String toString() {
        return "AppointmentModel{" +
                "appointmentId='" + appointmentId + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", patientName='" + patientName + '\'' +
                ", patientId='" + patientId + '\'' +
                ", dentistName='" + dentistName + '\'' +
                ", description='" + description + '\'' +
                ", service='" + service + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String appointmentId;
        private LocalDateTime startTime;
        private LocalDateTime endTime;
        private String patientName;
        private String patientId;
        private String dentistName;
        private String description;
        private String service;
        private String contactInfo;
        private String address;

        private Builder() {
        }

        public Builder withAppointmentId(String appointmentId) {
            this.appointmentId = appointmentId;
            return this;
        }

        public Builder withStartTime(LocalDateTime startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder withEndTime(LocalDateTime endTime) {
            this.endTime = endTime;
            return this;
        }

        public Builder withPatientName(String patientName) {
            this.patientName = patientName;
            return this;
        }

        public Builder withPatientId(String patientId) {
            this.patientId = patientId;
            return this;
        }

        public Builder withDentistName(String dentistName) {
            this.dentistName = dentistName;
            return this;
        }
        public Builder withContactInfo(String contactInfo) {
            this.contactInfo = contactInfo;
            return this;
        }
        public Builder withAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withService(String service) {
            this.service = service;
            return this;
        }

        public AppointmentModel build() {
            return new AppointmentModel(this);
        }
    }
    }


