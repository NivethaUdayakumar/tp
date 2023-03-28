package functionalities.parser;

import exception.SniffException;
import functionalities.commands.Command;
import functionalities.commands.ConsulationCommand;
import functionalities.commands.VaccinationCommand;
import functionalities.commands.RemoveCommand;
import functionalities.commands.SurgeryCommand;
import functionalities.commands.FindCommand;
import functionalities.commands.ListCommand;
import functionalities.commands.ExitCommand;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.logging.Logger;

public class Parser {

    protected static Command command;
    static Logger logger = Logger.getLogger("parser");

    public static Command parse(String userCommand) throws SniffException {
        String task = userCommand.trim();
        if (task.toLowerCase().startsWith("consultation")) {
            parseConsultationCommand(task);
        } else if (task.toLowerCase().startsWith("vaccination")) {
            parseVaccinationCommand(task);
        } else if (task.toLowerCase().startsWith("surgery")) {
            parseSurgeryCommand(task);
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

    private static void parseConsultationCommand(String task) throws SniffException {
        try {
            int animalTypeIndex = task.indexOf("at/");
            int animalNameIndex = task.indexOf("an/");
            int ownerNameIndex = task.indexOf("on/");
            int contactNumberIndex = task.indexOf("cn/");
            int consultationDateIndex = task.indexOf("cd/");
            int consultationTimeIndex = task.indexOf("ct/");
            String animalType = task.substring(animalTypeIndex + 3, animalNameIndex - 1);
            String animalName = task.substring(animalNameIndex + 3, ownerNameIndex - 1);
            String ownerName = task.substring(ownerNameIndex + 3, contactNumberIndex - 1);
            String contactNumber = task.substring(contactNumberIndex + 3, consultationDateIndex - 1);
            String date = task.substring(consultationDateIndex + 3, consultationTimeIndex - 1);
            LocalDate parsedDate = LocalDate.parse(date);
            String time = task.substring(consultationTimeIndex + 3);
            LocalTime parsedTime = LocalTime.parse(time);
            command = new ConsulationCommand(animalType, animalName, ownerName, contactNumber, parsedDate, parsedTime);
        } catch (StringIndexOutOfBoundsException e) {
            throw new SniffException(" The consultation description is invalid!");
        } catch (DateTimeParseException e) {
            throw new SniffException(" The date/time description is invalid.");
        }
    }

    private static void parseVaccinationCommand(String task) throws SniffException {
        try {
            int animalTypeIndex = task.indexOf("at/");
            int animalNameIndex = task.indexOf("an/");
            int ownerNameIndex = task.indexOf("on/");
            int contactNumberIndex = task.indexOf("cn/");
            int vaccineIndex = task.indexOf("v/");
            int vaccineDateIndex = task.indexOf("vd/");
            int vaccineTimeIndex = task.indexOf("vt/");
            String animalType = task.substring(animalTypeIndex + 3, animalNameIndex - 1);
            String animalName = task.substring(animalNameIndex + 3, ownerNameIndex - 1);
            String ownerName = task.substring(ownerNameIndex + 3, contactNumberIndex - 1);
            String contactNumber = task.substring(contactNumberIndex + 3, vaccineIndex - 1);
            String vaccine = task.substring(vaccineIndex + 2, vaccineDateIndex - 1);
            String date = task.substring(vaccineDateIndex + 3, vaccineTimeIndex - 1);
            LocalDate parsedDate = LocalDate.parse(date);
            String time = task.substring(vaccineTimeIndex + 3);
            LocalTime parsedTime = LocalTime.parse(time);
            command = new VaccinationCommand(animalType, animalName, ownerName, contactNumber,
                    vaccine, parsedDate, parsedTime);
        } catch (StringIndexOutOfBoundsException e) {
            throw new SniffException(" The vaccination description is invalid!");
        } catch (DateTimeParseException e) {
            throw new SniffException(" The date/time description is invalid.");
        }
    }

    private static void parseSurgeryCommand(String task) throws SniffException {
        try {
            int animalTypeIndex = task.indexOf("at/");
            int animalNameIndex = task.indexOf("an/");
            int ownerNameIndex = task.indexOf("on/");
            int contactNumberIndex = task.indexOf("cn/");
            int startDateIndex = task.indexOf("sd/");
            int startTimeIndex = task.indexOf("st/");
            int endDateIndex = task.indexOf("ed/");
            int endTimeIndex = task.indexOf("et/");
            int priorityIndex = task.indexOf("p/");
            String animalType = task.substring(animalTypeIndex + 3, animalNameIndex - 1);
            String animalName = task.substring(animalNameIndex + 3, ownerNameIndex - 1);
            String ownerName = task.substring(ownerNameIndex + 3, contactNumberIndex - 1);
            String contactNumber = task.substring(contactNumberIndex + 3, startDateIndex - 1);
            String startDate = task.substring(startDateIndex + 3, startTimeIndex - 1);
            LocalDate parsedStartDate = LocalDate.parse(startDate);
            String startTime = task.substring(startTimeIndex + 3, endDateIndex - 1);
            LocalTime parsedStartTime = LocalTime.parse(startTime);
            String endDate = task.substring(endDateIndex + 3, endTimeIndex - 1);
            LocalDate parsedEndDate = LocalDate.parse(endDate);
            String endTime = task.substring(endTimeIndex + 3, priorityIndex - 1);
            LocalTime parsedEndTime = LocalTime.parse(endTime);
            String priority = task.substring(priorityIndex + 2);
            if (parsedStartDate.isAfter(parsedEndDate)) {
                throw new SniffException(" The start date must be before the end date!");
            } else if (parsedStartDate.equals(parsedEndDate) && parsedStartTime.isAfter(parsedEndTime)) {
                throw new SniffException(" The start time must be before the end time!");
            } else if (parsedStartDate.equals(parsedEndDate) && parsedStartTime.equals(parsedEndTime)) {
                throw new SniffException(" The start time cannot be the same as the end time!");
            }
            command = new SurgeryCommand(animalType, animalName, ownerName, contactNumber,
                    parsedStartDate, parsedStartTime, parsedEndDate, parsedEndTime, priority);
        } catch (StringIndexOutOfBoundsException e) {
            throw new SniffException(" The surgery description is invalid!");
        } catch (DateTimeParseException e) {
            throw new SniffException(" The date/time description is invalid!");
        }
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
            assert uid != null;
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
