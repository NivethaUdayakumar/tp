package functionalities.commands;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class VaccinationCommandTest {

    @Test
    void vaccinationCommandNotNull() {
        String animalName = "";
        String animalType = "";
        String ownerName = "";
        String contactNumber = "";
        String vaccine = "";
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        VaccinationCommand c = new VaccinationCommand(animalType, animalName, ownerName,
                contactNumber, vaccine, date, time);
        assertNotNull(c);
    }
}
