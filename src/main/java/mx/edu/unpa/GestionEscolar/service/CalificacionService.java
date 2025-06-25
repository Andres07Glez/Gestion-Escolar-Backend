package mx.edu.unpa.GestionEscolar.service;

import java.util.Optional;

import mx.edu.unpa.GestionEscolar.domain.Calificacion;


public interface CalificacionService {
	public Iterable<Calificacion> findAll();
	//public Page<Teacher> findAll(Pageable pageable);
	public Optional<Calificacion> findById(String id);
	public Calificacion save(Calificacion calificacion);
	public void deleteById(String id);
}