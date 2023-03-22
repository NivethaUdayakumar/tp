package functionalities;

public class Owner {
    protected String name;
    protected String contactNumber;

    public Owner(String name, String contactNumber) {
        this.name = name;
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return name + " | Contact Number: " + contactNumber;
    }
}
