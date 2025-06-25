package mx.edu.unpa.GestionEscolar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.edu.unpa.GestionEscolar.domain.Estudiante;


@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante,String>{

}
