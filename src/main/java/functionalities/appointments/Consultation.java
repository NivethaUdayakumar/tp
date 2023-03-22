package functionalities.appointments;

import functionalities.Animal;
import functionalities.Owner;

public class Consultation extends Appointment {

    protected String date;
    protected String time;

    public Consultation(String uid, Animal animal, Owner owner, String date, String time) {
        super(uid, animal, owner);
        this.uid = uid;
        this.animal = animal;
        this.owner = owner;
        this.date = date;
        this.time = time;
    }

    @Override
    public String toString() {
        return " UID: " + uid + '\n'
                + " Date: " + date + " | Time: " + time + '\n'
                + " Animal Name: " + animal.toString() + '\n'
                + " Owner Name: " + owner.toString();
    }
}
