package seedu.sniff;

import static org.junit.jupiter.api.Assertions.assertTrue;

import exception.SniffException;
import functionalities.commands.Command;
import functionalities.commands.ConsulationCommand;
import functionalities.commands.ExitCommand;
import functionalities.commands.FindCommand;
import functionalities.commands.ListCommand;
import functionalities.commands.RemoveCommand;
import functionalities.commands.SurgeryCommand;
import functionalities.commands.VaccinationCommand;
import functionalities.parser.Parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParserTest {

    @Test
    public void consultationTest() {
        String consultationCommand = "consultation at/cat an/lulu on/jon cn/91919191 cd/2023-12-12 ct/19:00";
        Command consultationParsedCommand = null;
        try {
            consultationParsedCommand = Parser.parse(consultationCommand);
        } catch (SniffException e) {
            Assertions.fail("SniffException thrown when not expected");
        }
        assertTrue(consultationParsedCommand instanceof ConsulationCommand,
                "consultationParsedCommand is not an instance of ConsultationCommand");
    }

    @Test
    public void vaccinationTest() {
        String vaccinationCommand = "vaccination at/cat an/lulu on/jon cn/91919191 v/covid vd/2023-12-12 vt/19:00";
        Command vaccinationParsedCommand = null;
        try {
            vaccinationParsedCommand = Parser.parse(vaccinationCommand);
        } catch (SniffException e) {
            Assertions.fail("SniffException thrown when not expected");
        }
        assertTrue(vaccinationParsedCommand instanceof VaccinationCommand,
                "vaccinationParsedCommand is not an instance of VaccinationCommand");
    }

    @Test
    public void surgeryTest() {
        String surgeryCommand = "surgery at/cat an/lulu on/jon cn/91919191 " +
                "sd/2023-12-12 st/19:00 ed/2023-12-12 et/20:00 p/H";
        Command surgeryParsedCommand = null;
        try {
            surgeryParsedCommand = Parser.parse(surgeryCommand);
        } catch (SniffException e) {
            Assertions.fail("SniffException thrown when not expected");
        }
        assertTrue(surgeryParsedCommand instanceof SurgeryCommand,
                "surgeryParsedCommand is not an instance of SurgeryCommand");
    }

    @Test
    public void findTest() {
        String findCommand = "find a/dog";
        String findCommand1 = "find t/surgery";
        String findCommand2 = "find aID/123";
        Command findParsedCommand = null;
        try {
            findParsedCommand = Parser.parse(findCommand);
            findParsedCommand = Parser.parse(findCommand1);
            findParsedCommand = Parser.parse(findCommand2);
        } catch (SniffException e) {
            Assertions.fail("SniffException thrown when not expected");
        }
        assertTrue(findParsedCommand instanceof FindCommand,
                "findParsedCommand is not an instance of FindCommand");
    }

    @Test
    public void listTest() {
        String listCommand = "list";
        Command listParsedCommand = null;
        try {
            listParsedCommand = Parser.parse(listCommand);
        } catch (SniffException e) {
            Assertions.fail("SniffException thrown when not expected");
        }
        assertTrue(listParsedCommand instanceof ListCommand,
                "listParsedCommand is not an instance of ListCommand");
    }

    @Test
    public void removeTest() {
        String removeCommand = "remove a/1";
        Command removeParsedCommand = null;
        try {
            removeParsedCommand = Parser.parse(removeCommand);
        } catch (SniffException e) {
            Assertions.fail("SniffException thrown when not expected");
        }
        assertTrue(removeParsedCommand instanceof RemoveCommand,
                "removeParsedCommand is not an instance of RemoveCommand");
    }

    @Test
    public void byeTest() {
        String byeCommand = "bye";
        Command byeParsedCommand = null;
        try {
            byeParsedCommand = Parser.parse(byeCommand);
        } catch (SniffException e) {
            Assertions.fail("SniffException thrown when not expected");
        }
        assertTrue(byeParsedCommand instanceof ExitCommand,
                "byeParsedCommand is not an instance of ByeCommand");
    }
}
