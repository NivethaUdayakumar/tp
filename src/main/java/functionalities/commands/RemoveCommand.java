package functionalities.commands;

import exception.SniffException;
import functionalities.SniffTasks;
import functionalities.ui.Ui;

public class RemoveCommand extends Command {

    public String uid;

    public RemoveCommand(String uid) {
        this.uid = uid;
    }

    @Override
    public void executeCommand(SniffTasks tasks) throws SniffException {
        tasks.removeAppointment(uid);
        Ui.showUserMessage(" Task removed successfully!");
    }
}
