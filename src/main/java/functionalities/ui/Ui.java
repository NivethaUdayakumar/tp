package functionalities.ui;

import exception.SniffException;
import functionalities.appointments.Appointment;

import java.util.Scanner;

public class Ui {

    private static final String DOT_THEN_SPACE = ". ";
    private static final String LINE = "______________________________________________________________________";

    public static void showUserMessage(String s) {
        System.out.println(s);
    }

    public static void printFileCreated(boolean b) {
        showLine();
        System.out.println("\tFile \"SniffAppointments.txt\" created!");
        showLine();
    }

    public static void printEmptyFile() {
        showLine();
        System.out.println("No appointments saved!");
        showLine();
    }

    public static void printFileContents(Scanner s) {
        showLine();
        System.out.println("\tLoading saved appointments:");
        int index = 1;
        while (s.hasNext()) {
            System.out.println("\t" + index + ". " + s.nextLine());
            index++;
        }
        showLine();
    }

    public String readUserCommand() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public void showErrorMessage() {
        System.out.println(" Sorry, an error was encountered! Here is the error description:");
        SniffException.showError();
    }


    public void showWelcomeMessage() {
        showLine();
        System.out.println(" Hello! I'm Sniff, your personal appointment manager.");
        System.out.println(" What can I do for you?");
        showLine();
    }

    public static void showLine() {
        System.out.println(LINE);
    }

    public static void formatPrintList(int count, String description) {
        System.out.println(count + DOT_THEN_SPACE + description);
    }

    public static void printAppointmentAddedMessage(Appointment appointment) {
        System.out.println(" This appointment has been added to your appointment manager: ");
        System.out.println(appointment.toString());
    }

    public static void printAppointmentRemovedMessage(Appointment appointment) {
        System.out.println(" This appointment has been removed your appointment manager: ");
        System.out.println(appointment.toString());
    }

    public static void printAppointmentMarkMessage() {
        System.out.println("The appointment has been marked successfully");
    }

    public static void printAppointmentUnMarkMessage() {
        System.out.println("The appointment has been unmarked successfully");
    }
}
