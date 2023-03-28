package functionalities.commands;

import exception.SniffException;
import functionalities.Animal;
import functionalities.Owner;
import functionalities.SniffTasks;
import functionalities.ui.Ui;

import java.time.LocalDate;
import java.time.LocalTime;

public class ConsulationCommand extends Command {

    private final Animal animal;
    private final Owner owner;
    private final LocalDate date;
    private final LocalTime time;

    public ConsulationCommand(String animalType, String animalName,
                              String ownerName, String contactNumber, LocalDate date,
                              LocalTime time) {
        this.animal = new Animal(animalType, animalName);
        this.owner = new Owner(ownerName, contactNumber);
        this.date = date;
        this.time = time;
    }

    @Override
    public void executeCommand(SniffTasks tasks) throws SniffException {
        tasks.addConsultation(animal, owner, date, time);
        Ui.showUserMessage(" Consultation added successfully!");
    }
}
