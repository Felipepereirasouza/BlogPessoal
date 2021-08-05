package org.generation.blogpessoal.controller;

import java.util.List;

import javax.validation.Valid;

import org.generation.blogpessoal.model.Tema;
import org.generation.blogpessoal.repository.Tema_repository;
import org.springframework.beans.factory.annotation.Autowired;
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

@RequestMapping("/tema")
@RestController
@CrossOrigin (origins = "*", allowedHeaders = "*")

public class TemaController {

	@Autowired
	private Tema_repository repository;
	
	
	@GetMapping
	public ResponseEntity<List<Tema>> getall(){
		
		return ResponseEntity.ok(repository.findAll());
	}
	
	
	
	@GetMapping("/{id}")
	ResponseEntity<Tema> getbyid (@Valid @PathVariable long id )
	{
		return repository.findById(id).map(resp-> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	
	}
	
		
	@GetMapping ("name/{name}")
	
	ResponseEntity <List<Tema>> getbyNome (@Valid @PathVariable String name)
	{
		
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(name));
	
	}
	
	
	@PostMapping
	
	public ResponseEntity<Tema> post (@Valid @RequestBody Tema tema)
	{
		
		return ResponseEntity.ok(repository.save(tema));
		
	}
	
	@PutMapping
	
	public ResponseEntity<Tema> atualizar (@Valid @RequestBody Tema tema){
		
		return ResponseEntity.status(201).body(repository.save(tema));
		
	}
	
	@DeleteMapping("/{id}")
	
	public void deletar (@Valid @RequestBody @PathVariable long id){
		
		repository.deleteById(id);
	}

	
	
	
	
}



