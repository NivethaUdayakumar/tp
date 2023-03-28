package seedu.sniff;

import exception.SniffException;
import functionalities.Uid;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UidGeneratorTest {

    @Test
    public void uidNotNullTest() {
        try {
            String uid = Uid.uidGenerator("C");
            assertNotNull(uid, "Uid generated is null");
        } catch (SniffException e) {
            Assertions.fail();
        }

    }

    @Test
    public void uidLengthTest() {
        try {
            String uid = Uid.uidGenerator("C");
            assertEquals(10, uid.length());
        } catch (SniffException e) {
            Assertions.fail("Length of uid generated is incorrect.");
        }

    }

    @Test
    public void uidValidInputTest() {
        try {
            String uid = Uid.uidGenerator("S");
            uid = Uid.uidGenerator("V");
            uid = Uid.uidGenerator("C");
        } catch (SniffException e) {
            Assertions.fail("This test should not fail as they are valid inputs.");
        }
    }

    @Test
    public void uidLastCharTest() {
        try {
            String uid = Uid.uidGenerator("C");
            assertTrue(('A' <= uid.charAt(9)) && (uid.charAt(9) <= 'Z'),
                    "Letter should be between A to Z");
        } catch (SniffException e) {
            Assertions.fail("This test should not fail as it is a valid input");
        }
    }

    @Test
    public void uidWrongInputTest() {
        try {
            String uid = Uid.uidGenerator("A");
            Assertions.fail("This test should fail with invalid inputs");
        } catch (SniffException e) {
            assertEquals("Invalid appointment type for uid generation.", e.getErrorMessage());
        }
    }
}
