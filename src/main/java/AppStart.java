import service.AppointmentService;
import service.DoctorService;
import service.PatientService;
import service.impl.AppointmentServiceImpl;
import service.impl.DoctorServiceImpl;
import service.impl.PatientServiceImpl;
import utils.Authentication;

import java.util.Scanner;

public class AppStart {
    private static final PatientService patientService = new PatientServiceImpl();
    private static final DoctorService doctorService = new DoctorServiceImpl();
    private static final AppointmentService appointmentService = new AppointmentServiceImpl();

    public static void start() {
        Scanner scanner = new Scanner(System.in);
        if (Authentication.auth()) while (true) {
            System.out.print("""
                    0 - Escape
                    1 - Create patient
                    2 - Create doctor
                    3 - Create appointment
                    4 - Delete patient
                    5 - Show all patients
                    6 - Edit patients fio
                    7 - Show all patient's appointments
                    8 - Change appointment status
                    """);
            switch (scanner.nextInt()) {
                case 0 -> System.exit(0);
                case 1 -> patientService.createPatient();
                case 2 -> doctorService.createDoctor();
                case 3 -> appointmentService.createAppointment();
                case 4 -> patientService.deleteUser();
                case 5 -> patientService.showAllPatients();
                case 6 -> patientService.editPatientFio();
                case 7 -> appointmentService.showAllPatientAppointments();
                case 8 -> appointmentService.changeAppointmentStatus();
            }
        }
        else {
            System.out.println("Incorrect!");
        }
    }
}
