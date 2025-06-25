package mx.edu.unpa.GestionEscolar.service;

import java.util.Optional;

import mx.edu.unpa.GestionEscolar.domain.Curso;


public interface CursoService {
	public Iterable<Curso> findAll();
	//public Page<Teacher> findAll(Pageable pageable);
	public Optional<Curso> findById(String id);
	public Curso save(Curso curso);
	public void deleteById(String id);
}
