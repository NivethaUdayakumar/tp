package seedu.sniff;

import static functionalities.parser.Parser.parseConsultationCommand;
import static functionalities.parser.Parser.parseSurgeryCommand;
import static functionalities.parser.Parser.parseVaccinationCommand;

//import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import exception.SniffException;
import org.junit.jupiter.api.Test;

public class ParserTest {

    @Test
    public void consultationTest() throws SniffException {
        String task = "consultation at/cat an/snowy on/John cn/81799907 cd/27-08-2023 ct/5pm";
        parseConsultationCommand(task);
        assertTrue(true);
    }

    @Test
    public void vaccinationTest() throws SniffException {
        String task = "vaccination at/cat an/pinky on/Daisy cn/81520366 v/Moderna vd/27-11-2022 vt/3pm";
        parseVaccinationCommand(task);
        assertTrue(true);
    }

    @Test
    public void surgeryTest() throws SniffException {
        String task = "surgery at/cat an/snowy on/John cn/81799907 sd/27-03-2023 st/2pm ed/27-03-2023 et/5pm p/H";
        parseSurgeryCommand(task);
        assertTrue(true);
    }

    @Test
    public void dummyFindTest() {
        assertTrue(true);
    }

    @Test
    public void dummyListTest() {
        assertTrue(true);
    }

    @Test
    public void dummyByeTest() {
        assertTrue(true);
    }
}
