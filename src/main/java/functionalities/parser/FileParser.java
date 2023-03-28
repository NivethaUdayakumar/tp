package functionalities.parser;

import functionalities.Animal;
import functionalities.Owner;
import functionalities.SniffTasks;
import functionalities.appointments.Appointment;
import functionalities.appointments.Consultation;
import functionalities.appointments.Surgery;
import functionalities.appointments.Vaccination;

import java.time.LocalDate;
import java.time.LocalTime;

public class FileParser {

    static String uid;
    static Animal animal;
    static Owner owner;
    static LocalDate date;
    static LocalTime time;
    static LocalDate startDate;
    static LocalDate endDate;
    static LocalTime endTime;
    static LocalTime startTime;
    static String priority;
    static String vaccine;

    public static void addConsultation(String currentLine) {
        String[] split = currentLine.split(" \\| ");
        uid = split[0];
        animal = new Animal(split[4], split[3]);
        owner = new Owner(split[5], split[6]);
        date = LocalDate.parse(split[1]);
        time = LocalTime.parse(split[2]);
        SniffTasks.addAppointmentUID(uid);
        Appointment newAppointment = new Consultation(uid, animal, owner, date, time);
        SniffTasks.addAppointment(newAppointment);
    }

    public static void addSurgery(String currentLine) {
        String[] split = currentLine.split(" \\| ");
        uid = split[0];
        priority = split[1];
        animal = new Animal(split[3], split[2]);
        owner = new Owner(split[4], split[5]);
        startDate = LocalDate.parse(split[6]);
        endDate = LocalDate.parse(split[8]);
        startTime = LocalTime.parse(split[7]);
        endTime = LocalTime.parse(split[9]);
        SniffTasks.addAppointmentUID(uid);
        Appointment newAppointment = new Surgery(uid, animal, owner, priority, startDate, startTime, endDate, endTime);
        SniffTasks.addAppointment(newAppointment);
    }

    public static void addVaccination(String currentLine) {
        String[] split = currentLine.split(" \\| ");
        uid = split[0];
        animal = new Animal(split[5], split[4]);
        owner = new Owner(split[6], split[7]);
        date = LocalDate.parse(split[2]);
        time = LocalTime.parse(split[3]);
        vaccine = split[1];
        SniffTasks.addAppointmentUID(uid);
        Appointment newAppointment = new Vaccination(uid, animal, owner, date, time, vaccine);
        SniffTasks.addAppointment(newAppointment);
    }
}
