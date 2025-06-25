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

import mx.edu.unpa.GestionEscolar.domain.Estudiante;
import mx.edu.unpa.GestionEscolar.service.EstudianteService;



@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/estudiante")
public class EstudianteAController {

	//@Autowired
	//private VeterinariosRepository veterinariosRepository;
	
	@Autowired
	private EstudianteService estudianteService;
	
	@GetMapping(path = "/app")
	public Iterable<Estudiante> index() {
		return this.estudianteService.findAll();
		
	}
	@GetMapping("/add")
	public String add(Estudiante estudiante) {
		return "add";
	}
	
	@GetMapping("/fnd")
	public ResponseEntity<?> read(@RequestParam("id") String estudianteId) {
		Optional<Estudiante> oEstudiante=this.estudianteService.findById(estudianteId);
		if(oEstudiante.isPresent()) {
			LinkedList<Estudiante> estudianteList=new LinkedList<>();
			estudianteList.add(oEstudiante.get());
			return ResponseEntity.ok(estudianteList);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estudiante no encontrado");
			
		}
	}
	
	@PostMapping("/create")
	public ResponseEntity<Estudiante> create(@RequestBody Estudiante estudiante) {
		
		Estudiante saveEstudiante=this.estudianteService.save(estudiante);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveEstudiante);
	}
	
	@DeleteMapping("/del/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") String estudianteId) {
		Optional<Estudiante> oEstudiante=this.estudianteService.findById(estudianteId);
		if(oEstudiante.isPresent()) {
			this.estudianteService.deleteById(estudianteId);
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@GetMapping("/upd/{id}")
	public ResponseEntity<Estudiante> upd(@PathVariable(value="id") String estudianteId) {
		Optional<Estudiante> oEstudiante=this.estudianteService.findById(estudianteId);
		if(oEstudiante.isPresent()) {
			return ResponseEntity.ok(oEstudiante.get());
			
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PutMapping("/save")
	public ResponseEntity<Estudiante> save(@RequestBody Estudiante estudiante) {
		if(estudiante != null) {
			this.estudianteService.save(estudiante);
			return ResponseEntity.status(HttpStatus.CREATED).body(estudiante);
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		
	}
}