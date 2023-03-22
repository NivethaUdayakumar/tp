package functionalities.commands;

import exception.SniffException;
import functionalities.Animal;
import functionalities.Owner;
import functionalities.SniffTasks;
import functionalities.ui.Ui;

public class SurgeryCommand extends Command {

    private final Animal animal;
    private final Owner owner;
    private final String priority;
    private final String startDate;
    private final String startTime;
    private final String endDate;
    private final String endTime;

    public SurgeryCommand(String animalType, String animalName, String ownerName,
                          String contactNumber, String startDate, String startTime,
                          String endDate, String endTime, String priority) {
        this.priority = priority;
        this.animal = new Animal(animalType, animalName);
        this.owner = new Owner(ownerName, contactNumber);
        this.startDate = startDate;
        this.startTime = startTime;
        this.endDate = endDate;
        this.endTime = endTime;
    }

    @Override
    public void executeCommand(SniffTasks tasks) throws SniffException {
        tasks.addSurgery(animal, owner, priority, startDate, startTime, endDate, endTime);
        Ui.showUserMessage(" Surgery added successfully!");
    }
}
