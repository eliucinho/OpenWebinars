package net.openwebinars.taller.app.modelos;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@NoArgsConstructor
@Entity
public class Auto {

	@Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String modelo;
	private String marca;
	private int anio;
	private double precio;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private Date fecha;
}
