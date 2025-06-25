package mx.edu.unpa.GestionEscolar.controller;

import java.util.LinkedList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.unpa.GestionEscolar.domain.Profesor;
import mx.edu.unpa.GestionEscolar.service.ProfesorService;




@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/profesor")
public class ProfesorAController {

	//@Autowired
	//private VeterinariosRepository veterinariosRepository;
	
	@Autowired
	private ProfesorService profesorService;
	
	@GetMapping(path = "/app")
	public Iterable<Profesor> index() {
		return this.profesorService.findAll();
		
	}
	@GetMapping("/add")
	public String add(Profesor profesor) {
		return "add";
	}
	
	@GetMapping("/fnd")
	public ResponseEntity<?> read(@RequestParam("id") String profesorId) {
		Optional<Profesor> oProfesor=this.profesorService.findById(profesorId);
		if(oProfesor.isPresent()) {
			LinkedList<Profesor> profesorList=new LinkedList<>();
			profesorList.add(oProfesor.get());
			return ResponseEntity.ok(profesorList);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estudiante no encontrado");
			
		}
	}
	
	@PostMapping("/create")
	public ResponseEntity<Profesor> create(@RequestBody Profesor profesor) {
		
		Profesor saveProfesor=this.profesorService.save(profesor);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveProfesor);
	}
	
	@DeleteMapping("/del/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") String profesorId) {
		Optional<Profesor> oProfesor=this.profesorService.findById(profesorId);
		if(oProfesor.isPresent()) {
			this.profesorService.deleteById(profesorId);
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@GetMapping("/upd/{id}")
	public ResponseEntity<Profesor> upd(@PathVariable(value="id") String profesorId) {
		Optional<Profesor> oEstudiante=this.profesorService.findById(profesorId);
		if(oEstudiante.isPresent()) {
			return ResponseEntity.ok(oEstudiante.get());
			
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PutMapping("/save")
	public ResponseEntity<Profesor> save(@RequestBody Profesor profesor) {
		if(profesor != null) {
			this.profesorService.save(profesor);
			return ResponseEntity.status(HttpStatus.CREATED).body(profesor);
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		
	}
}