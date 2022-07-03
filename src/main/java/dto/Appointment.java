package dto;

import enums.AppointmentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

@Getter
@Setter
public class Appointment {

   private UUID id = UUID.randomUUID();

    private String patientFio;
    private Calendar registrationDate;

    private AppointmentStatus status;

    public String getRegistrationDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(registrationDate.getTime());
    }
    public Appointment(String patientFio, Calendar registrationDate,AppointmentStatus status){

        this.patientFio = patientFio;
        this.registrationDate = registrationDate;
        this.status = status;
    }
}
