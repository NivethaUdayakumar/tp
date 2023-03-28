package seedu.sniff;

import exception.SniffException;
import functionalities.commands.Command;
import functionalities.storage.Storage;
import functionalities.ui.Ui;
import functionalities.parser.Parser;
import functionalities.SniffTasks;

import java.io.IOException;

public class Sniff {
    private static SniffTasks tasks;
    private static Ui UI;
    private static Storage storage;

    public Sniff() {
        UI = new Ui();
        tasks = new SniffTasks();
        storage = new Storage();
    }

    public void run() throws SniffException, IOException {
        String absolutePath = getPath();
        Storage.openFile(absolutePath);
        UI.showWelcomeMessage();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = UI.readUserCommand();
                UI.showLine();
                Command c = Parser.parse(fullCommand);
                c.executeCommand(tasks);
                isExit = c.isExit();
            } catch (SniffException e) {
                UI.showErrorMessage();
            } finally {
                storage.saveAppointments(absolutePath);
                UI.showLine();
            }
        }
    }

    private static String getPath() {
        String home = System.getProperty("user.home");
        java.nio.file.Path path = java.nio.file.Paths.get(home, "SniffAppointments.txt");
        String absolutePath = path.toString();
        return absolutePath;
    }

    /**
     * Main entry-point for the java.sniff.Sniff application.
     */
    public static void main(String[] args) throws SniffException, IOException {
        new Sniff().run();
    }
}
