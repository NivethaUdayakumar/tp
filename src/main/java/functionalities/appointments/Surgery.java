package functionalities.appointments;

import functionalities.Animal;
import functionalities.Owner;

import java.time.LocalDate;
import java.time.LocalTime;

public class Surgery extends Appointment {

    public enum priorityLevel {
        HIGH, MEDIUM, LOW, NA
    }

    protected priorityLevel priority;
    protected LocalDate startDate;
    protected LocalTime startTime;
    protected LocalDate endDate;
    protected LocalTime endTime;
    protected char priorityType;
    protected String description = "surgery";

    public Surgery(String uid, Animal animal, Owner owner, String priority,
                   LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime) {
        super(uid, animal, owner);
        this.uid = uid;
        this.animal = animal;
        this.owner = owner;
        this.priorityType = priority.charAt(0);
        this.priority = setPriority(priority);
        this.startDate = startDate;
        this.startTime = startTime;
        this.endDate = endDate;
        this.endTime = endTime;
    }

    public priorityLevel setPriority(String priority) {
        switch (priority) {
        case "H":
            return priorityLevel.HIGH;
        case "M":
            return priorityLevel.MEDIUM;
        case "L":
            return priorityLevel.LOW;
        default:
            return priorityLevel.NA;
        }
    }

    @Override
    public String toString() {
        return " UID: " + uid + " [" + getStatus() + "]" + " | Priority: " + priority + '\n'
                + " Animal Name: " + animal.toString() + '\n'
                + " Owner Name: " + owner.toString() + '\n'
                + " Start Date: " + startDate + " | Start Time: " + startTime + '\n'
                + " End Date: " + endDate + " | End Time: " + endTime;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String retrieveStorageInfo() {
        return uid + " | " + priorityType + " | " + animal.getAnimalName() + " | " + animal.getAnimalType() + " | "
                + owner.getName() + " | " + owner.getContactNumber() + " | " + startDate + " | " + startTime + " | "
                + endDate + " | " + endTime;
    }
}
