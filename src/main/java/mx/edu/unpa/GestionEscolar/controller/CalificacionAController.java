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

import mx.edu.unpa.GestionEscolar.domain.Calificacion;
import mx.edu.unpa.GestionEscolar.service.CalificacionService;



@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/calificacion")
public class CalificacionAController {

	//@Autowired
	//private VeterinariosRepository veterinariosRepository;
	
	@Autowired
	private CalificacionService calificacionService;
	
	@GetMapping(path = "/app")
	public Iterable<Calificacion> index() {
		return this.calificacionService.findAll();
		
	}
	@GetMapping("/add")
	public String add(Calificacion calificacion) {
		return "add";
	}
	
	@GetMapping("/fnd")
	public ResponseEntity<?> read(@RequestParam("id") String calificacionId) {
		Optional<Calificacion> oCalificacion=this.calificacionService.findById(calificacionId);
		if(oCalificacion.isPresent()) {
			LinkedList<Calificacion> calificacionList=new LinkedList<>();
			calificacionList.add(oCalificacion.get());
			return ResponseEntity.ok(calificacionList);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Calificacion no encontrada");
			
		}
	}
	
	@PostMapping("/create")
	public ResponseEntity<Calificacion> create(@RequestBody Calificacion calificacion) {
		
		Calificacion saveCalificacion=this.calificacionService.save(calificacion);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveCalificacion);
	}
	
	@DeleteMapping("/del/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") String calificacionId) {
		Optional<Calificacion> oCalificacion=this.calificacionService.findById(calificacionId);
		if(oCalificacion.isPresent()) {
			this.calificacionService.deleteById(calificacionId);
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@GetMapping("/upd/{id}")
	public ResponseEntity<Calificacion> upd(@PathVariable(value="id") String calificacionId) {
		Optional<Calificacion> oCalificacion=this.calificacionService.findById(calificacionId);
		if(oCalificacion.isPresent()) {
			return ResponseEntity.ok(oCalificacion.get());
			
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PutMapping("/save")
	public ResponseEntity<Calificacion> save(@RequestBody Calificacion calificacion) {
		if(calificacion != null) {
			this.calificacionService.save(calificacion);
			return ResponseEntity.status(HttpStatus.CREATED).body(calificacion);
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		
	}
}
