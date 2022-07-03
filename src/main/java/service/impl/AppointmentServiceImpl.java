package service.impl;

import data.Storage;
import dto.Appointment;
import enums.AppointmentStatus;
import service.AppointmentService;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.UUID;

public class AppointmentServiceImpl implements AppointmentService {


    @Override
    public void createAppointment() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter patient fio: ");
        String patientFio = scanner.nextLine();
        System.out.print("Enter reg year: ");
        int year = scanner.nextInt();
        System.out.print("Enter reg month: ");
        int month = scanner.nextInt();
        System.out.print("Enter reg day: ");
        int day = scanner.nextInt();
        Calendar registrationDate = new GregorianCalendar(year, month, day);

        Appointment appointment = new Appointment(patientFio, registrationDate, AppointmentStatus.NEW);

        Storage.appointments.add(appointment);
    }

    @Override
    public void showAllPatientAppointments() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter patient fio: ");
        String patientFio = scanner.nextLine();

        if (Storage.appointments.stream().noneMatch(a -> a.getPatientFio().equals(patientFio))) {
            System.out.println("This patient has no appointments");
            return;
        }

        System.out.println("List of appointments for " + patientFio);
        Storage.appointments.forEach(a -> {
            if (a.getPatientFio().equals(patientFio))
                System.out.println(a.getRegistrationDate() + " " + a.getStatus().toString());
        });

    }

    @Override
    public void changeAppointmentStatus() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter appointment id: ");
        UUID appointmentId = UUID.fromString(scanner.nextLine());

        System.out.print("""
                Enter new status:
                0 - NEW
                1 - IN THE PROCESS
                2 - CANCELLED
                3 - AWAITING PAYMENT
                4 - COMPLETED
                """);

        int statusCode = scanner.nextInt();
        AppointmentStatus newStatus = null;

        switch (statusCode) {
            case 0 -> newStatus = AppointmentStatus.NEW;
            case 1 -> newStatus = AppointmentStatus.IN_PROCESS;
            case 2 -> newStatus = AppointmentStatus.CANCELLED;
            case 3 -> newStatus = AppointmentStatus.AWAITING_PAYMENT;
            case 4 -> newStatus = AppointmentStatus.COMPLETED;
        }

        Storage.appointments.stream().filter(a -> a.getId().equals(appointmentId)).findFirst().get().setStatus(newStatus);

    }
}
