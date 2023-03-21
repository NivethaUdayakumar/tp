package functionalities;


public abstract class Appointment {

    protected String uid;
    protected Animal animal;
    protected Owner owner;
    protected boolean status;

    public Appointment(String uid, Animal animal, Owner owner) {
        this.animal = animal;
        this.owner = owner;
        this.status = false;
    }

    public abstract String toString();
}

