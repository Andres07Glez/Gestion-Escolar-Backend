package mx.edu.unpa.GestionEscolar.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.unpa.GestionEscolar.domain.Curso;
import mx.edu.unpa.GestionEscolar.repository.CursoRepository;



@Service
public class CursoServiceImpl implements CursoService{
	@Autowired
	private CursoRepository cursoRepository;

	@Override
	@Transactional(readOnly=true)
	public Iterable<Curso> findAll() {
		// TODO Auto-generated method stub
		return this.cursoRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Curso> findById(String id) {
		// TODO Auto-generated method stub
		return this.cursoRepository.findById(id);
	}

	@Override
	@Transactional
	public Curso save(Curso curso) {
		// TODO Auto-generated method stub
		return this.cursoRepository.save(curso);
	}

	@Override
	@Transactional
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		this.cursoRepository.deleteById(id);
		
	}

}
