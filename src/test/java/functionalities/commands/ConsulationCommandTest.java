package functionalities.commands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ConsulationCommandTest {

    @Test
    void consultationCommandNotNull() {
        String animalName = "";
        String animalType = "";
        String ownerName = "";
        String contactNumber = "";
        String date = "";
        String time = "";
        ConsulationCommand c = new ConsulationCommand(animalType, animalName, ownerName,
                contactNumber, date, time);
        assertNotNull(c);
    }
}
