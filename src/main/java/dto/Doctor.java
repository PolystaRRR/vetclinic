package dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Doctor {
    private UUID id = UUID.randomUUID();

    private String fio;

    public Doctor(String fio) {
        this.fio = fio;
    }
}
