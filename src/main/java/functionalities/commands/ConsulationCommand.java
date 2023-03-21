package functionalities.commands;

import exception.SniffException;
import functionalities.Animal;
import functionalities.Owner;
import functionalities.SniffTasks;
import functionalities.Ui;

public class ConsulationCommand extends Command {
    private final String uid;
    private final Animal animal;
    private final Owner owner;
    private final String date;
    private final String time;

    public ConsulationCommand(String uid, String animalType, String animalName,
                              String ownerName, String contactNumber, String date,
                              String time) {
        this.uid = uid;
        this.animal = new Animal(animalType, animalName);
        this.owner = new Owner(ownerName, contactNumber);
        this.date = date;
        this.time = time;

    }

    @Override
    public void executeCommand(SniffTasks tasks) throws SniffException {
        tasks.addConsultation(animal, owner, date, time);
        Ui.showUserMessage(" Surgery added successfully");
    }
}
