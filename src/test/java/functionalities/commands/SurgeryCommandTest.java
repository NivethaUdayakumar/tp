package functionalities.commands;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class SurgeryCommandTest {

    @Test
    void surgeryCommandNotNull() {
        String animalName = "";
        String animalType = "";
        String ownerName = "";
        String contactNumber = "";
        LocalDate startDate = LocalDate.now();
        LocalTime startTime = LocalTime.now();
        LocalDate endDate = LocalDate.now();
        LocalTime endTime = LocalTime.now();
        String priority = "";
        SurgeryCommand c = new SurgeryCommand(animalType, animalName, ownerName,
                contactNumber, startDate, startTime, endDate, endTime, priority);
        assertNotNull(c);
    }
}
