package functionalities.commands;
import exception.SniffException;
import functionalities.SniffTasks;
import functionalities.ui.Ui;


public class UnMarkCommand extends Command {
    public String uid;

    public UnMarkCommand (String uid){
        this.uid = uid;
    }
    public void executeCommand(SniffTasks tasks) throws SniffException {
        tasks.unmarkAppointment(uid);
        Ui.showUserMessage(" Task marked successfully!");
    }

}
