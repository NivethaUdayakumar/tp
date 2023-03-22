package functionalities;

import exception.SniffException;
import functionalities.appointments.Appointment;
import functionalities.appointments.Consultation;
import functionalities.appointments.Surgery;
import functionalities.appointments.Vaccination;
import functionalities.ui.Ui;

import java.util.ArrayList;
import java.util.HashMap;

public class SniffTasks {

    private static final ArrayList<Appointment> APPOINTMENTS = new ArrayList<>();
    private static final HashMap<String, Integer> UIDS = new HashMap<>();

    private static int appointmentCount = 0;

    public void addConsultation(Animal animal, Owner owner,
                                String date, String time) throws SniffException {
        try {
            String uid = Uid.uidGenerator("C");
            while (UIDS.containsKey(uid)) { // this loop checks for duplicate appointment ids
                uid = Uid.uidGenerator("C");
            }
            UIDS.put(uid, appointmentCount);
            Appointment newAppointment = new Consultation(uid, animal, owner, date, time);
            APPOINTMENTS.add(newAppointment);
            Ui.printAppointmentAddedMessage(newAppointment);
            appointmentCount++;
        } catch (StringIndexOutOfBoundsException e) {
            throw new SniffException(" Invalid consultation description!");
        }
    }

    public void addVaccination(Animal animal, Owner owner,
                               String date, String time, String vaccine) throws SniffException {
        try {
            String uid = Uid.uidGenerator("V");
            while (UIDS.containsKey(uid)) { // this loop checks for duplicate appointment ids
                uid = Uid.uidGenerator("V");
            }
            Appointment newAppointment = new Vaccination(uid, animal, owner, date, time, vaccine);
            APPOINTMENTS.add(newAppointment);
            UIDS.put(uid, appointmentCount);
            Ui.printAppointmentAddedMessage(newAppointment);
            appointmentCount++;
        } catch (StringIndexOutOfBoundsException e) {
            throw new SniffException(" Invalid vaccination description!");
        }
    }

    public void addSurgery(Animal animal, Owner owner,
                           String priority, String startDate, String startTime,
                           String endDate, String endTime) throws SniffException {
        try {
            String uid = Uid.uidGenerator("S");
            while (UIDS.containsKey(uid)) { // this loop checks for duplicate appointment ids
                uid = Uid.uidGenerator("S");
            }
            UIDS.put(uid, appointmentCount);
            Appointment newAppointment =
                    new Surgery(uid, animal, owner, priority, startDate, startTime, endDate, endTime);
            APPOINTMENTS.add(newAppointment);
            Ui.printAppointmentAddedMessage(newAppointment);
            appointmentCount++;
        } catch (StringIndexOutOfBoundsException e) {
            throw new SniffException(" Invalid surgery description!");
        }
    }

    public void removeAppointment(String uid) throws SniffException {
        try {
            if (!UIDS.containsKey(uid)) {
                throw new SniffException(" There are no appointments with this ID.");
            }
            int index = UIDS.get(uid);
            Appointment temp = APPOINTMENTS.get(index);
            APPOINTMENTS.remove(index);
            UIDS.remove(uid, index);
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
            if (type.equalsIgnoreCase(String.valueOf(appointment))) {
                Ui.formatPrintList(counter, appointment.toString());
                counter++;
            }
        }
        if (counter == 1) {
            Ui.showUserMessage(" There are no appointments of this type!");
        }
    }
}
