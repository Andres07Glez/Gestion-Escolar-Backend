package mx.edu.unpa.GestionEscolar.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.unpa.GestionEscolar.domain.Profesor;
import mx.edu.unpa.GestionEscolar.repository.ProfesorRepository;



@Service
public class ProfesorServiceImpl implements ProfesorService {
	@Autowired
	private ProfesorRepository profesorRepository;

	@Override
	@Transactional(readOnly=true)
	public Iterable<Profesor> findAll() {
		// TODO Auto-generated method stub
		return this.profesorRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Profesor> findById(String id) {
		// TODO Auto-generated method stub
		return this.profesorRepository.findById(id);
	}

	@Override
	@Transactional
	public Profesor save(Profesor profesor) {
		// TODO Auto-generated method stub
		return this.profesorRepository.save(profesor);
	}

	@Override
	@Transactional
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		this.profesorRepository.deleteById(id);
		
	}

}

