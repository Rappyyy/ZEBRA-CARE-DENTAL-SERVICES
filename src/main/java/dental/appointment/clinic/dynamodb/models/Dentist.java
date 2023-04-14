package dental.appointment.clinic.dynamodb.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import dental.appointment.clinic.dependency.Weekday;

import java.util.List;

@DynamoDBTable(tableName = "dentists")
public class Dentist {
    private String id;
    private String name;
    private String position;
    private List<Weekday> availability;
    private int contactNumber;

    public Dentist() {
        
    }

    public Dentist(String id, String name, String position, List<Weekday> availability, int contactNumber) {
        this.id = id;
        this.position = position;
        this.name = name;
        this.availability = availability;
        this.contactNumber = contactNumber;
    }

    @DynamoDBHashKey(attributeName = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @DynamoDBAttribute(attributeName = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @DynamoDBAttribute(attributeName = "position")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @DynamoDBAttribute(attributeName = "availability")
    public List<Weekday> getAvailability() {
        return availability;
    }

    public void setAvailability(List<Weekday> availability) {
        this.availability = availability;
    }

    @DynamoDBAttribute(attributeName = "contactNumber")
    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }
}
