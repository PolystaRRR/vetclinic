package dto;


import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

@Getter
@Setter
public class Patient {

    private UUID id = UUID.randomUUID();

    private String fio;

    private Calendar registrationDate;

    public String getRegistrationDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(registrationDate.getTime());
    }

    public Patient(String fio, Calendar registrationDate) {

        this.fio = fio;
        this.registrationDate = registrationDate;
    }
}
