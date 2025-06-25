package mx.edu.unpa.GestionEscolar.domain;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="tbl_calificaciones")
public class Calificacion implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	private String id;
	@Column(name="inscripcion_id")
	private String inscripcionId;
	private float nota;
	private String observaciones;
	private LocalDate fecha;

}
