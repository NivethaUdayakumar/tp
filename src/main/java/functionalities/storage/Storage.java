package functionalities.storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import exception.SniffException;
import functionalities.SniffTasks;
import functionalities.parser.FileParser;
import functionalities.ui.Ui;

public class Storage {

    public static void saveAppointments(String path) throws IOException, SniffException {
        try {
            File fileName = new File(path);
            FileWriter savedFile = new FileWriter(fileName, false);
            SniffTasks.retrieveTask(savedFile);
            savedFile.write(System.getProperty("line.separator"));
            savedFile.close();
        } catch (IOException a) {
            throw new SniffException("Save file not found!");
        }
    }

    public static void openFile(String absolutePath) throws SniffException {
        try {
            File fileName = new File(absolutePath);
            if (fileName.createNewFile()) {
                Ui.printFileCreated(true);
            } else {
                extractData(fileName);
            }
        } catch (IOException e) {
            Ui.printFileCreated(false);
        } catch (IndexOutOfBoundsException e) {
            throw new SniffException("\tFile \"SniffAppointments.txt\" saved in incorrect format!");
        }
    }

    public static void extractData(File fileName) throws FileNotFoundException, SniffException {
        Scanner s = new Scanner(fileName);
        int count = 0;
        while (s.hasNext()) {
            String currentLine = s.nextLine();
            char appointmentType = currentLine.charAt(0);
            if (appointmentType == 'C') {
                FileParser.addConsultation(currentLine);
            } else if (appointmentType == 'S') {
                FileParser.addSurgery(currentLine);
            } else if (appointmentType == 'V') {
                FileParser.addVaccination(currentLine);
            } else {
                throw new SniffException("Appointments saved in wrong format!");
            }
            count++;
        }
        SniffTasks.setAppointmentCount(count);
    }
}
