package functionalities;

import exception.SniffException;
import functionalities.commands.Command;
import functionalities.commands.ExitCommand;
import functionalities.commands.ListCommand;
import functionalities.commands.RemoveCommand;
import functionalities.commands.FindCommand;

import java.util.logging.Logger;

public class Parser {
    protected static Command command;
    static Logger logger = Logger.getLogger("parser");
    private static final String NA = null; //Not Applicable

    public static Command parse(String userCommand) throws SniffException {
        String task = userCommand.trim();
        if (task.toLowerCase().startsWith("add")) {
            parseAddCommand(task);
        } else if (task.toLowerCase().startsWith("find")) {
            parseFindCommand(task);
        } else if (task.toLowerCase().startsWith("list")) {
            parseListCommand();
        } else if (task.toLowerCase().startsWith("remove")) {
            parseRemoveCommand(task);
        } else if (task.equalsIgnoreCase("bye")) {
            parseByeCommand();
        } else {
            throw new SniffException(" Not a recognized Sniff command!");
        }
        return command;
    }

    private static void parseAddCommand(String task) throws SniffException {
        try {
            String userCommand = "add";
            int uidIndex = task.indexOf("aID/");
            int typeIndex = task.indexOf("t/");
            int animalIndex = task.indexOf("a/");
            int nameIndex = task.indexOf("n/");
            int dateIndex = task.indexOf("d/");
            String uId = task.substring(uidIndex + 4, typeIndex - 1);
            String type = task.substring(typeIndex + 2, animalIndex - 1);
            String animal = task.substring(animalIndex + 2, nameIndex - 1);
            String name = task.substring(nameIndex + 2, dateIndex - 1);
            String date = task.substring(dateIndex + 2);
            //command = new Command(userCommand, uId, type, animal, name, date);
        } catch (StringIndexOutOfBoundsException e) {
            throw new SniffException(" The add command description is invalid!");
        }
    }

    private static void parseConsultationCommand(String task) throws SniffException {

    }

    private static void parseVaccinationCommand(String task) throws SniffException {

    }

    private static void parseSurgeryCommand(String task) throws SniffException {

    }

    private static void parseMarkCommand(String task) throws SniffException {

    }

    private static void parseUnmarkCommand(String task) throws SniffException {

    }

    private static void parseFindCommand(String task) throws SniffException {
        try {
            // find a/dog or find t/surgery or find aID/123
            int animalIndex = task.indexOf("a/");
            int typeIndex = task.indexOf("t/");
            int aIDIndex = task.indexOf("aID/");
            if (animalIndex != -1) {
                String details = task.substring(animalIndex + 2);
                command = new FindCommand("animal", details);
            } else if (typeIndex != -1) {
                String details = task.substring(typeIndex + 2);
                command = new FindCommand("type", details);
            } else if (aIDIndex != -1) {
                String details = task.substring(aIDIndex + 4);
                command = new FindCommand("appointment", details);
            } else {
                logger.warning(" NULL command returned to Sniff.run");
                throw new SniffException(" Invalid details provided for find command. Unable to execute find command.");
            }
        } catch (ArrayIndexOutOfBoundsException emptyFind) {
            logger.warning(" Invalid details provided for find command. Unable to execute find command.");
            throw new SniffException(" The find command description cannot be empty!");
        } catch (NumberFormatException e) {
            logger.warning(" Invalid appointment ID format provided. Integer numbers are expected.");
            throw new SniffException(" The user Id to view appointment details must be a number!");
        }
    }

    private static void parseListCommand() {
        command = new ListCommand();
    }

    private static void parseRemoveCommand(String task) throws SniffException {
        try {
            String uid = task.split(" ", 2)[1];
            command = new RemoveCommand(uid);
        } catch (ArrayIndexOutOfBoundsException e) {
            logger.warning("No appointment ID provided for remove command. Unable to execute view command.");
            throw new SniffException(" The remove command description cannot be empty!");
        } catch (NumberFormatException e) {
            logger.warning("Invalid appointment ID format. Integer numbers are expected.");
            throw new SniffException(" The remove command description must be a number!");
        } catch (IndexOutOfBoundsException e) {
            logger.warning("Out of Range appointment ID provided for remove command.");
            throw new SniffException(" The remove command index is invalid!");
        }
    }

    private static void parseByeCommand() {
        command = new ExitCommand();
    }
}
