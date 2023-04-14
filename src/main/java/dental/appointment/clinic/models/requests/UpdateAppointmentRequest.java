package dental.appointment.clinic.models.requests;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class UpdateAppointmentRequest {
    private String id;

    private String patientId;

    private String startTime;


    private String endTime;

    private String patientName;
    private String dentistName;
    private String description;
    private String service;
    private String contactInfo;

    private String address;

    public UpdateAppointmentRequest() {

    }

    private UpdateAppointmentRequest(Builder builder) {
        this.id = builder.id;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.patientName = builder.patientName;
        this.dentistName = builder.dentistName;
        this.description = builder.description;
        this.service = builder.service;
        this.contactInfo = builder.contactInfo;
        this.address = builder.address;
        this.patientId = builder.patientId;
    }

    public String getId() {
        return id;
    }
    public String getPatientId() {
        return id;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getPatientName() {
        return patientName;
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

    public String getContactInfo() {
        return contactInfo;
    }
    public String getAddress() {
        return address;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setDentistName(String dentistName) {
        this.dentistName = dentistName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setService(String service) {
        this.service = service;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UpdateAppointmentRequest)) return false;
        UpdateAppointmentRequest that = (UpdateAppointmentRequest) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getPatientId(), that.getPatientId()) && Objects.equals(getStartTime(), that.getStartTime()) && Objects.equals(getEndTime(), that.getEndTime()) && Objects.equals(getPatientName(), that.getPatientName()) && Objects.equals(getDentistName(), that.getDentistName()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getService(), that.getService()) && Objects.equals(getContactInfo(), that.getContactInfo()) && Objects.equals(getAddress(), that.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPatientId(), getStartTime(), getEndTime(), getPatientName(), getDentistName(), getDescription(), getService(), getContactInfo(), getAddress());
    }

    @Override
    public String toString() {
        return "UpdateAppointmentRequest{" +
                "id='" + id + '\'' +
                ", patientId='" + patientId + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", patientName='" + patientName + '\'' +
                ", dentistName='" + dentistName + '\'' +
                ", description='" + description + '\'' +
                ", service='" + service + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static class Builder {
        private String id;
        private String patientId;
        private String startTime;
        private String endTime;
        private String address;
        private String patientName;
        private String dentistName;
        private String description;
        private String service;
        private String contactInfo;

        public Builder(String id, String patientId, String startTime, String endTime, String patientName,
                       String dentistName, String description, String service, String contactInfo, String address) {
            this.id = id;
            this.patientId = patientId;
            this.startTime = startTime;
            this.endTime = endTime;
            this.patientName = patientName;
            this.dentistName = dentistName;
            this.description = description;
            this.service = service;
            this.contactInfo = contactInfo;
            this.address = address;
        }

        public Builder withStartTime(String startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder withEndTime(String endTime) {

            this.endTime = endTime;
            return this;
        }
        public Builder withId(String id) {
            this.id = id;
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
        public Builder withService(String service) {
            this.service = service;
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

        public UpdateAppointmentRequest build() {
            return new UpdateAppointmentRequest(this);
        }
    }

}

