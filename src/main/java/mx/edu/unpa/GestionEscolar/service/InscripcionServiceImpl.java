package mx.edu.unpa.GestionEscolar.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.unpa.GestionEscolar.domain.Inscripcion;
import mx.edu.unpa.GestionEscolar.repository.InscripcionRepository;



@Service
public class InscripcionServiceImpl implements InscripcionService{
	@Autowired
	private InscripcionRepository inscripcionRepository;

	@Override
	@Transactional(readOnly=true)
	public Iterable<Inscripcion> findAll() {
		// TODO Auto-generated method stub
		
		return this.inscripcionRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Inscripcion> findById(String id) {
		// TODO Auto-generated method stub
		return this.inscripcionRepository.findById(id);
	}

	@Override
	@Transactional
	public Inscripcion save(Inscripcion inscripcion) {
		// TODO Auto-generated method stub
		return this.inscripcionRepository.save(inscripcion);
	}

	@Override
	@Transactional
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		this.inscripcionRepository.deleteById(id);
	}

}

