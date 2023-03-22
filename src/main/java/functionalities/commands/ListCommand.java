package functionalities.commands;

import exception.SniffException;
import functionalities.SniffTasks;

public class ListCommand extends Command {
    public ListCommand() {
    }

    @Override
    public void executeCommand(SniffTasks tasks) throws SniffException {
        tasks.listAppointments();
    }
}
