package functionalities.commands;

import exception.SniffException;
import functionalities.SniffTasks;
import functionalities.ui.Ui;

public class ExitCommand extends Command {

    public ExitCommand() {
    }

    @Override
    public void executeCommand(SniffTasks tasks) throws SniffException {
        this.isExit = true;
        Ui.showUserMessage(" Bye, hope to see you again soon!");
    }
}
