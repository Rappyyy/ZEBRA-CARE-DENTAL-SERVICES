package dental.appointment.clinic.models.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import dental.appointment.clinic.util.PatientsUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class CreateAppointmentRequest {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime startTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime endTime;
    private String patientName;
    private String dentistName;
    private  String contactInfo;
    private String description;
    private String address;
    private String service;

    public CreateAppointmentRequest() {
    }

    public CreateAppointmentRequest(LocalDateTime startTime, LocalDateTime endTime, String patientName,
                                    String dentistName, String address, String description, String service) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.patientName = patientName;
        this.dentistName = dentistName;
        this.address = address;
        this.description = description;
        this.service = service;
    }



    private CreateAppointmentRequest(Builder builder) {
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.patientName = builder.patientName;
        this.dentistName = builder.dentistName;
        this.description = builder.description;
        this.address  = builder.address;
        this.service = builder.service;
        this.contactInfo = builder.contactInfo;

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

    public void setStartTime(String startTime) {
        this.startTime = LocalDateTime.parse(startTime);
    }

    public void setEndTime(String endTime) {
        this.endTime = LocalDateTime.parse(endTime);
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setDentistName(String dentistName) {
        this.dentistName = dentistName;
    }
    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setService(String service) {
        this.service = service;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateAppointmentRequest)) return false;
        CreateAppointmentRequest that = (CreateAppointmentRequest) o;
        return Objects.equals(getStartTime(), that.getStartTime()) && Objects.equals(getEndTime(),
                that.getEndTime()) && Objects.equals(getPatientName(), that.getPatientName()) &&
                Objects.equals(getDentistName(), that.getDentistName()) && Objects.equals(getDescription(),
                that.getDescription()) && Objects.equals(getService(), that.getService()) &&
                Objects.equals(getContactInfo(), that.getContactInfo()) && Objects.equals(getAddress(),
                that.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStartTime(), getEndTime(), getPatientName(), getDentistName(),
                getDescription(), getService(), getContactInfo(), getAddress());
    }

    @Override
    public String toString() {
        return "CreateAppointmentRequest{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", patientName='" + patientName + '\'' +
                ", dentistName='" + dentistName + '\'' +
                ", description='" + description + '\'' +
                ", service='" + service + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static Builder builder() { return new Builder(); }

    public static final class Builder {

        private LocalDateTime startTime;
        private LocalDateTime endTime;
        private String patientName;
        private String dentistName;
        private String contactInfo;
        private String address;
        private String description;
        private String service;

        public Builder withStartTime(String startTime) {
            this.startTime = LocalDateTime.parse(startTime);
            return this;
        }

        public Builder withEndTime(String endTime) {
            this.endTime = LocalDateTime.parse(endTime);
            return this;
        }

        public Builder withPatientName(String patientName) {
            this.patientName = patientName;
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

        public CreateAppointmentRequest build() {
            return new CreateAppointmentRequest(this);
        }
    }
}
