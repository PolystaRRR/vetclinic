package data;

import dto.Appointment;
import dto.Doctor;
import dto.Patient;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    public static List<Patient> patients = new ArrayList<>();
    public static List<Doctor> doctors = new ArrayList<>();
    public static List<Appointment> appointments = new ArrayList<>();
}
