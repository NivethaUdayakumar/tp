package functionalities.commands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class VaccinationCommandTest {

    @Test
    void vaccinationCommandNotNull() {
        String animalName = "";
        String animalType = "";
        String ownerName = "";
        String contactNumber = "";
        String vaccine = "";
        String date = "";
        String time = "";
        VaccinationCommand c = new VaccinationCommand(animalType, animalName, ownerName,
                contactNumber, vaccine, date, time);
        assertNotNull(c);
    }
}
