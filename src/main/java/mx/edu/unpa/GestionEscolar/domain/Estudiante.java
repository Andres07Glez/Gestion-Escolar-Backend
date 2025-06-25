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
@Table(name="tbl_estudiantes")
public class Estudiante implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	private String id;
	private String nombre;
	private String apellido;
	@Column(name="fecha_nacimiento")
	private LocalDate fechaNacimiento;
	private String email;
	

}
