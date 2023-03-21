package functionalities.commands;

import exception.SniffException;
import functionalities.SniffTasks;

public class UnknownCommand extends Command {
    public UnknownCommand() {

    }

    @Override
    public void executeCommand(SniffTasks tasks) throws SniffException {
        throw new SniffException(" Not a recognized Sniff Command!");
    }
}
