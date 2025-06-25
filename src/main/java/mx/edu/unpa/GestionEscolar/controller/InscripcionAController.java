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

import mx.edu.unpa.GestionEscolar.domain.Inscripcion;
import mx.edu.unpa.GestionEscolar.service.InscripcionService;



@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/inscripcion")
public class InscripcionAController {

	//@Autowired
	//private VeterinariosRepository veterinariosRepository;
	
	@Autowired
	private InscripcionService inscripcionService;
	
	@GetMapping(path = "/app")
	public Iterable<Inscripcion> index() {
		return this.inscripcionService.findAll();
		
	}
	@GetMapping("/add")
	public String add(Inscripcion inscripcion) {
		return "add";
	}
	
	@GetMapping("/fnd")
	public ResponseEntity<?> read(@RequestParam("id") String inscripcionId) {
		Optional<Inscripcion> oInscripcion=this.inscripcionService.findById(inscripcionId);
		if(oInscripcion.isPresent()) {
			LinkedList<Inscripcion> inscripcionList=new LinkedList<>();
			inscripcionList.add(oInscripcion.get());
			return ResponseEntity.ok(inscripcionList);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Inscripcion no encontrada");
			
		}
	}
	
	@PostMapping("/create")
	public ResponseEntity<Inscripcion> create(@RequestBody Inscripcion inscripcion) {
		
		Inscripcion saveInscripcion=this.inscripcionService.save(inscripcion);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveInscripcion);
	}
	
	@DeleteMapping("/del/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") String inscripcionId) {
		Optional<Inscripcion> oInscripcion=this.inscripcionService.findById(inscripcionId);
		if(oInscripcion.isPresent()) {
			this.inscripcionService.deleteById(inscripcionId);
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@GetMapping("/upd/{id}")
	public ResponseEntity<Inscripcion> upd(@PathVariable(value="id") String inscripcionId) {
		Optional<Inscripcion> oInscripcion=this.inscripcionService.findById(inscripcionId);
		if(oInscripcion.isPresent()) {
			return ResponseEntity.ok(oInscripcion.get());
			
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PutMapping("/save")
	public ResponseEntity<Inscripcion> save(@RequestBody Inscripcion inscripcion) {
		if(inscripcion != null) {
			this.inscripcionService.save(inscripcion);
			return ResponseEntity.status(HttpStatus.CREATED).body(inscripcion);
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		
	}
}
