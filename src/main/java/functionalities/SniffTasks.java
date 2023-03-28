package functionalities;

import exception.SniffException;
import functionalities.appointments.Appointment;
import functionalities.appointments.Consultation;
import functionalities.appointments.Surgery;
import functionalities.appointments.Vaccination;
import functionalities.ui.Ui;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;

public class SniffTasks {

    private static final ArrayList<Appointment> APPOINTMENTS = new ArrayList<>();
    private static final HashSet<String> UIDS = new HashSet<>();
    private static int appointmentCount = 0;

    public static void setAppointmentCount(int count) {
        appointmentCount = count;
    }

    public static void addAppointmentUID(String UID) {
        UIDS.add(UID);
    }

    public static void addAppointment(Appointment appointment) {
        APPOINTMENTS.add(appointment);
    }

    public static int getAppointmentCount() {
        return appointmentCount;
    }

    public static void retrieveTask(FileWriter savedFile) throws IOException {
        for (int index = 0; index < SniffTasks.getAppointmentCount(); index++) {
            if (APPOINTMENTS.get(index).getStatus().equals(" ")) {
                savedFile.write(APPOINTMENTS.get(index).retrieveStorageInfo());
                savedFile.write(System.getProperty("line.separator"));
            }
        }
    }

    public void addConsultation(Animal animal, Owner owner,
                                LocalDate date, LocalTime time) throws SniffException {
        try {
            String uid = Uid.uidGenerator("C");
            while (UIDS.contains(uid)) { // this loop checks for duplicate appointment ids
                uid = Uid.uidGenerator("C");
            }
            UIDS.add(uid);
            Appointment newAppointment = new Consultation(uid, animal, owner, date, time);
            APPOINTMENTS.add(newAppointment);
            Ui.printAppointmentAddedMessage(newAppointment);
            appointmentCount++;
        } catch (StringIndexOutOfBoundsException e) {
            throw new SniffException(" Invalid consultation description!");
        }
    }

    public void addVaccination(Animal animal, Owner owner,
                               LocalDate date, LocalTime time, String vaccine) throws SniffException {
        try {
            String uid = Uid.uidGenerator("V");
            while (UIDS.contains(uid)) { // this loop checks for duplicate appointment ids
                uid = Uid.uidGenerator("C");
            }
            UIDS.add(uid);
            Appointment newAppointment = new Vaccination(uid, animal, owner, date, time, vaccine);
            APPOINTMENTS.add(newAppointment);
            Ui.printAppointmentAddedMessage(newAppointment);
            appointmentCount++;
        } catch (StringIndexOutOfBoundsException e) {
            throw new SniffException(" Invalid vaccination description!");
        }
    }

    public void addSurgery(Animal animal, Owner owner,
                           String priority, LocalDate startDate, LocalTime startTime,
                           LocalDate endDate, LocalTime endTime) throws SniffException {
        try {
            String uid = Uid.uidGenerator("S");
            while (UIDS.contains(uid)) { // this loop checks for duplicate appointment ids
                uid = Uid.uidGenerator("C");
            }
            UIDS.add(uid);
            Appointment newAppointment = new Surgery(uid, animal, owner, priority, startDate, startTime, endDate,
                    endTime);
            APPOINTMENTS.add(newAppointment);
            Ui.printAppointmentAddedMessage(newAppointment);
            appointmentCount++;
        } catch (StringIndexOutOfBoundsException e) {
            throw new SniffException(" Invalid surgery description!");
        }
    }

    public void removeAppointment(String uid) throws SniffException {
        try {
            if (!UIDS.contains(uid)) {
                throw new SniffException(" There are no appointments with this ID.");
            }
            int index = 0;
            for (int i = 0; i < appointmentCount; i++) {
                if (uid.equals(APPOINTMENTS.get(i).uid)) {
                    index = i;
                    break;
                }
            }
            Appointment temp = APPOINTMENTS.get(index);
            APPOINTMENTS.remove(index);
            UIDS.remove(uid);
            Ui.printAppointmentRemovedMessage(temp);
            appointmentCount--;
            assert appointmentCount >= 0 : "Appointment count cannot be less than 0";
        } catch (IndexOutOfBoundsException e) {
            throw new SniffException(" The remove command entry is invalid!");
        }
    }

    /**
     * Lists out all the appointment currently in the appointment list.
     */
    public void listAppointments() {
        int counter = 1;
        if (APPOINTMENTS.isEmpty()) {
            Ui.showUserMessage("No entries found!");
        }
        for (Appointment appointment : APPOINTMENTS) {
            Ui.formatPrintList(counter, appointment.toString());
            counter++;
        }
    }

    public void findAppointment(String uId) throws SniffException {
        int counter = 1;
        for (Appointment appointment : APPOINTMENTS) {
            assert appointment.uid != null;
            if (uId.equalsIgnoreCase(appointment.uid)) {
                Ui.formatPrintList(counter, appointment.toString());
                counter++;
            }
        }
        if (uId.equals("")) {
            throw new SniffException(" No appointment ID provided!");
        }
        if (!uId.matches("\\d+")) {
            throw new SniffException(" Appointment ID must consist of integers!");
        }
        if (counter == 1) {
            Ui.showUserMessage(" There are no appointments with this ID!");
        }
    }

    public void findAnimal(String animal) {
        int counter = 1;
        for (Appointment appointment : APPOINTMENTS) {
            assert appointment.animal.type != null;
            if (animal.equalsIgnoreCase(appointment.animal.type)) {
                Ui.formatPrintList(counter, appointment.toString());
                counter++;
            }
        }
        if (counter == 1) {
            Ui.showUserMessage(" There are no appointments for this animal type!");
        }
    }

    public void findType(String type) {
        int counter = 1;
        for (Appointment appointment : APPOINTMENTS) {
            assert appointment != null;
            if (type.equalsIgnoreCase(appointment.getDescription())) {
                Ui.formatPrintList(counter, appointment.toString());
                counter++;
            }
        }
        if (counter == 1) {
            Ui.showUserMessage(" There are no appointments of this type!");
        }
    }

    public void markAppointment(String uid) throws SniffException {
        try {
            if (!UIDS.contains(uid)) {
                throw new SniffException(" There are no appointments with this ID.");
            }
            int index = 0;
            for (int i = 0; i < appointmentCount; i++) {
                if (uid.equals(APPOINTMENTS.get(i).uid)) {
                    index = i;
                    break;
                }
            }
            APPOINTMENTS.get(index).setIsDone(true);
            Ui.printAppointmentMarkMessage();
            assert appointmentCount >= 0 : "Appointment count cannot be less than 0";
        } catch (IndexOutOfBoundsException e) {
            throw new SniffException(" The mark command entry is invalid!");
        }

    }

    public void unmarkAppointment(String uid) throws SniffException {
        try {
            if (!UIDS.contains(uid)) {
                throw new SniffException(" There are no appointments with this ID.");
            }
            int index = 0;
            for (int i = 0; i < appointmentCount; i++) {
                if (uid.equals(APPOINTMENTS.get(i).uid)) {
                    index = i;
                    break;
                }
            }
            APPOINTMENTS.get(index).setIsDone(false);
            Ui.printAppointmentUnMarkMessage();
            assert appointmentCount >= 0 : "Appointment count cannot be less than 0";
        } catch (IndexOutOfBoundsException e) {
            throw new SniffException(" The unmark command entry is invalid!");
        }

    }


}
