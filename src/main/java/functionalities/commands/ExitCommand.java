package functionalities.commands;

import exception.SniffException;
import functionalities.SniffTasks;

public class ExitCommand extends Command {

    public ExitCommand() {
    }

    @Override
    public void executeCommand(SniffTasks tasks) throws SniffException {
        this.isExit = true;
    }
}
