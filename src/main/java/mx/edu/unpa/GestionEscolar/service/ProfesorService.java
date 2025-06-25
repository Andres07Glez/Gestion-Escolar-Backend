package mx.edu.unpa.GestionEscolar.service;

import java.util.Optional;

import mx.edu.unpa.GestionEscolar.domain.Profesor;


public interface ProfesorService {
	public Iterable<Profesor> findAll();
	//public Page<Teacher> findAll(Pageable pageable);
	public Optional<Profesor> findById(String id);
	public Profesor save(Profesor profesor);
	public void deleteById(String id);
}