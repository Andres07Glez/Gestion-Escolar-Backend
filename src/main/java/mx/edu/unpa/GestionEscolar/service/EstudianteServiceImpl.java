package mx.edu.unpa.GestionEscolar.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.unpa.GestionEscolar.domain.Estudiante;
import mx.edu.unpa.GestionEscolar.repository.EstudianteRepository;



@Service
public class EstudianteServiceImpl implements EstudianteService{
	@Autowired
	private EstudianteRepository estudianteRepository;

	@Override
	@Transactional(readOnly=true)
	public Iterable<Estudiante> findAll() {
		// TODO Auto-generated method stub
		return this.estudianteRepository.findAll();
	}

	@Override
	@Transactional
	public Estudiante save(Estudiante estudiante) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.save(estudiante);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Estudiante> findById(String id) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.findById(id);
	}

	@Override
	@Transactional
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		this.estudianteRepository.deleteById(id);;
	}

}

