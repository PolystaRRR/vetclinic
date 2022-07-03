package service.impl;

import data.Storage;
import dto.Doctor;
import service.DoctorService;

import java.util.Scanner;

public class DoctorServiceImpl implements DoctorService {


    @Override
    public void createDoctor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter fio: ");
        String fio = scanner.nextLine();

        Storage.doctors.add(new Doctor(fio));
        System.out.println("Dr " + fio + " was added!");
    }
}
