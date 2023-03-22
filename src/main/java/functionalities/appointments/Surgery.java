package functionalities.appointments;

import functionalities.Animal;
import functionalities.Owner;

public class Surgery extends Appointment {

    public enum priorityLevel {
        HIGH, MEDIUM, LOW, NA
    }

    protected priorityLevel priority;
    protected String startDate;
    protected String startTime;
    protected String endDate;
    protected String endTime;

    protected String description = "surgery";

    public Surgery(String uid, Animal animal, Owner owner, String priority,
                   String startDate, String startTime, String endDate, String endTime) {
        super(uid, animal, owner);
        this.uid = uid;
        this.animal = animal;
        this.owner = owner;
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
        return " UID: " + uid +  " | Priority: " + priority + '\n'
                + " Animal Name: " + animal.toString() + '\n'
                + " Owner Name: " + owner.toString() + '\n'
                + " Start Date: " + startDate + " | Start Time: " + startTime + '\n'
                + " End Date: " + endDate + " | End Time: " + endTime;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
