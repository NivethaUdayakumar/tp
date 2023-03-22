package functionalities.commands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;


class ListCommandTest {

    @Test
    void listCommandNotNullTest() {
        ListCommand c = new ListCommand();
        assertNotNull(c);
    }
}
