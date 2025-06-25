package mx.edu.unpa.GestionEscolar.service;

import java.util.Optional;

import mx.edu.unpa.GestionEscolar.domain.Estudiante;


public interface EstudianteService {
	
	public Iterable<Estudiante> findAll();
	//public Page<Teacher> findAll(Pageable pageable);
	public Optional<Estudiante> findById(String id);
	public Estudiante save(Estudiante estudiante);
	public void deleteById(String id);

}
