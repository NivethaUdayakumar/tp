package functionalities.commands;

import exception.SniffException;
import functionalities.SniffTasks;

public abstract class Command {
    public boolean isExit;

    protected Command() {
        this.isExit = false;
    }

    public boolean isExit() {
        return isExit;
    }

    public void executeCommand(SniffTasks tasks) throws SniffException {
    }
}
