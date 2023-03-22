package functionalities.appointments;

import functionalities.Animal;
import functionalities.Owner;

public abstract class Appointment {

    public String uid;
    public Animal animal;
    protected Owner owner;
    protected boolean status;

    public Appointment(String uid, Animal animal, Owner owner) {
        this.uid = uid;
        this.animal = animal;
        this.owner = owner;
        this.status = false;
    }

    public abstract String toString();
}
