package mx.edu.unpa.GestionEscolar.service;

import java.util.Optional;

import mx.edu.unpa.GestionEscolar.domain.Inscripcion;


public interface InscripcionService {
	public Iterable<Inscripcion> findAll();
	//public Page<Teacher> findAll(Pageable pageable);
	public Optional<Inscripcion> findById(String id);
	public Inscripcion save(Inscripcion inscripcion);
	public void deleteById(String id);
}
