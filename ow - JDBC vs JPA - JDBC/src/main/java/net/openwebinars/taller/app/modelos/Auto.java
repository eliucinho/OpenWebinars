package net.openwebinars.taller.app.modelos;

import java.util.Date;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@NoArgsConstructor
public class Auto {

	private Long id;
	private String modelo;
	private String marca;
	private int anio;
	private double precio;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private Date fecha;
}
