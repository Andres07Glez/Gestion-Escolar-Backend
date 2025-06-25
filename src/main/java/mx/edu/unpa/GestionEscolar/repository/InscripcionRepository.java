package mx.edu.unpa.GestionEscolar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.edu.unpa.GestionEscolar.domain.Inscripcion;


@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion,String>{

}