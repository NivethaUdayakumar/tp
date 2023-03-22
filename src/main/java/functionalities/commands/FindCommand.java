package functionalities.commands;

import exception.SniffException;
import functionalities.SniffTasks;

public class FindCommand extends Command {

    protected String category;
    protected String details;

    public FindCommand(String category, String details) {
        this.category = category;
        this.details = details;
    }

    @Override
    public void executeCommand(SniffTasks tasks) throws SniffException {
        if (category.equals("appointment")) {
            tasks.findAppointment(details);
        } else if (category.equals("animal")) {
            tasks.findAnimal(details);
        } else if (category.equals("type")) {
            tasks.findType(details);
        } else {
            throw new SniffException("Unsupported find command!");
        }
    }

}
