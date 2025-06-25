package mx.edu.unpa.GestionEscolar.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="tbl_cursos")
public class Curso implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	private String id;
	private String nombre;
	private String descripcion;
	@Column(name="profesor_id")
	private String profesorId;
	private int creditos;

	
}
