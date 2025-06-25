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
@Table(name="tbl_inscripciones")
public class Inscripcion implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	private String id;
	@Column(name="estudiante_id")
	private String estudianteId;
	@Column(name="curso_id")
	private String cursoId;
	private LocalDate fecha;

}
