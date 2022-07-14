package net.openwebinars.taller.app.modelos;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
public class Auto {

    @Id
    private String placa;
    private String marca;
    private String modelo;
    private String propietario;
}
