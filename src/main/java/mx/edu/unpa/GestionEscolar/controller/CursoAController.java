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

import mx.edu.unpa.GestionEscolar.domain.Curso;
import mx.edu.unpa.GestionEscolar.service.CursoService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/curso")
public class CursoAController {
	//@Autowired
		//private VeterinariosRepository veterinariosRepository;
		
		@Autowired
		private CursoService cursoService;
		
		@GetMapping(path = "/app")
		public Iterable<Curso> index() {
			return this.cursoService.findAll();
			
		}
		@GetMapping("/add")
		public String add(Curso curso) {
			return "add";
		}
		
		@GetMapping("/fnd")
		public ResponseEntity<?> read(@RequestParam("id") String cursoId) {
			Optional<Curso> oCurso=this.cursoService.findById(cursoId);
			if(oCurso.isPresent()) {
				LinkedList<Curso> cursoList=new LinkedList<>();
				cursoList.add(oCurso.get());
				return ResponseEntity.ok(cursoList);
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso no encontrado");
				
			}
		}
		
		@PostMapping("/create")
		public ResponseEntity<Curso> create(@RequestBody Curso curso) {
			
			Curso saveCurso=this.cursoService.save(curso);
			return ResponseEntity.status(HttpStatus.CREATED).body(saveCurso);
		}
		
		@DeleteMapping("/del/{id}")
		public ResponseEntity<Void> delete(@PathVariable("id") String cursoId) {
			Optional<Curso> oCurso=this.cursoService.findById(cursoId);
			if(oCurso.isPresent()) {
				this.cursoService.deleteById(cursoId);
				return ResponseEntity.noContent().build();
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}
		
		@GetMapping("/upd/{id}")
		public ResponseEntity<Curso> upd(@PathVariable(value="id") String cursoId) {
			Optional<Curso> oCurso=this.cursoService.findById(cursoId);
			if(oCurso.isPresent()) {
				return ResponseEntity.ok(oCurso.get());
				
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}
		
		@PutMapping("/save")
		public ResponseEntity<Curso> save(@RequestBody Curso curso) {
			if(curso != null) {
				this.cursoService.save(curso);
				return ResponseEntity.status(HttpStatus.CREATED).body(curso);
			}else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
			
			
		}
}
