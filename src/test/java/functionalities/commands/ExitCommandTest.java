package functionalities.commands;

import exception.SniffException;
import functionalities.SniffTasks;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ExitCommandTest {

    @Test
    void exitCommandNotNullTest() {
        Command c = new ExitCommand();
        assertNotNull(c);
    }
    @Test
    void exitCommandTest() throws SniffException {
        SniffTasks tasks = new SniffTasks();
        Command c = new ExitCommand();
        c.executeCommand(tasks);
        assertTrue(c.isExit);
    }
}
