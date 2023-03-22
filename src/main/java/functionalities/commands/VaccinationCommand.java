package functionalities.commands;

import exception.SniffException;
import functionalities.Animal;
import functionalities.Owner;
import functionalities.SniffTasks;
import functionalities.ui.Ui;

public class VaccinationCommand extends Command {
    private final Animal animal;
    private final Owner owner;
    private final String vaccine;
    private final String date;
    private final String time;

    public VaccinationCommand(String animalType, String animalName, String ownerName,
                              String contactNumber, String vaccine, String date, String time) {
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
