package mx.edu.unpa.GestionEscolar.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.unpa.GestionEscolar.domain.Calificacion;
import mx.edu.unpa.GestionEscolar.repository.CalificacionRepository;



@Service
public class CalificacionServiceImpl implements CalificacionService{
	
	@Autowired
	private CalificacionRepository calificacionRepository;

	@Override
	@Transactional(readOnly=true)
	public Iterable<Calificacion> findAll() {
		// TODO Auto-generated method stub
		return this.calificacionRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Calificacion> findById(String id) {
		// TODO Auto-generated method stub
		return this.calificacionRepository.findById(id);
	}

	@Override
	@Transactional
	public Calificacion save(Calificacion calificacion) {
		// TODO Auto-generated method stub
		return this.calificacionRepository.save(calificacion);
	}

	@Override
	@Transactional
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		this.calificacionRepository.deleteById(id);
		
	}

}
