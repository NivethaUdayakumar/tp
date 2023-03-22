package functionalities;

public class Animal {
    protected String type;
    protected String name;

    public Animal(String type, String name) {
        this.type = type;
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " | Animal Type: " + type;
    }
}
