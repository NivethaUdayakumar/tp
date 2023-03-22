package seedu.sniff;

import exception.SniffException;
import functionalities.commands.Command;
import functionalities.ui.Ui;
import functionalities.parser.Parser;
import functionalities.SniffTasks;

public class Sniff {
    private static SniffTasks tasks;
    private static Ui UI;

    public Sniff() {
        UI = new Ui();
        tasks = new SniffTasks();
        //Implement Storage later
    }

    public void run() {
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
                UI.showLine();
            }
        }
    }

    /**
     * Main entry-point for the java.sniff.Sniff application.
     */
    public static void main(String[] args) {
        new Sniff().run();
    }

}
