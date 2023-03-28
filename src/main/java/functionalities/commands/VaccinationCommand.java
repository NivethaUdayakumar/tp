package functionalities.commands;

import exception.SniffException;
import functionalities.Animal;
import functionalities.Owner;
import functionalities.SniffTasks;
import functionalities.ui.Ui;

import java.time.LocalDate;
import java.time.LocalTime;

public class VaccinationCommand extends Command {
    private final Animal animal;
    private final Owner owner;
    private final String vaccine;
    private final LocalDate date;
    private final LocalTime time;

    public VaccinationCommand(String animalType, String animalName, String ownerName,
                              String contactNumber, String vaccine, LocalDate date, LocalTime time) {
        this.animal = new Animal(animalType, animalName);
        this.owner = new Owner(ownerName, contactNumber);
        this.vaccine = vaccine;
        this.date = date;
        this.time = time;
    }

    @Override
    public void executeCommand(SniffTasks tasks) throws SniffException {
        tasks.addVaccination(animal, owner, date, time, vaccine);
        Ui.showUserMessage(" Vaccination added successfully!");
    }
}
