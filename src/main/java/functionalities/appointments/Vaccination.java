package functionalities.appointments;

import functionalities.Animal;
import functionalities.Owner;

public class Vaccination extends Appointment {
    protected String date;
    protected String time;
    protected String vaccine;
    protected String description = "vaccination";

    public Vaccination(String uid, Animal animal, Owner owner, String date, String time, String vaccine) {
        super(uid, animal, owner);
        this.uid = uid;
        this.animal = animal;
        this.owner = owner;
        this.date = date;
        this.time = time;
        this.vaccine = vaccine;
    }

    @Override
    public String toString() {
        return " UID: " + uid + " | vaccine: " + vaccine + '\n'
                + " Date: " + date + " | Time: " + time + '\n'
                + " Animal Name: " + animal.toString() + '\n'
                + " Owner Name: " + owner.toString();
    }

    @Override
    public String getDescription() {
        return description;
    }
}
