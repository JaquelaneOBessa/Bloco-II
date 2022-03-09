package com.generation.Farmacia.Controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.generation.Farmacia.Repository.CategoriaRepository;
import com.generation.Farmacia.model.CategoriaModel;

@RestController// API Rest
@RequestMapping("/categoria")// mapeamento da url
@CrossOrigin (origins = "*" , allowedHeaders = "*")

public class CategoriaController {

	@Autowired
	private CategoriaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<CategoriaModel>>getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
@GetMapping("/{id}")
public ResponseEntity<CategoriaModel> getByIdEntity(@PathVariable long id){
	return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
}
@GetMapping("/nome/{nome}")
public ResponseEntity<List<CategoriaModel>> getByNome(@PathVariable String nome){
	return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	} 
@PostMapping
public ResponseEntity<CategoriaModel>post(@RequestBody CategoriaModel nome){
	return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(nome));
}
@PutMapping
public ResponseEntity<CategoriaModel>put(@RequestBody CategoriaModel nome){
	return ResponseEntity.status(HttpStatus.OK).body(repository.save(nome));
}
@DeleteMapping("/{id}")
public void delete(@PathVariable long id) {
	repository.deleteById(id);
	
}
}
