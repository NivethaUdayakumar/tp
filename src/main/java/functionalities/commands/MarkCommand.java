package functionalities.commands;
import exception.SniffException;
import functionalities.SniffTasks;
import functionalities.ui.Ui;


public class MarkCommand extends Command {
    public String uid;

    public MarkCommand (String uid){
        this.uid = uid;
    }
    public void executeCommand(SniffTasks tasks) throws SniffException {
        tasks.markAppointment(uid);
        Ui.showUserMessage(" Task marked successfully!");
    }

}
