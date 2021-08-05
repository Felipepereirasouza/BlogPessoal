package org.generation.blogpessoal.controller;
import java.util.List;

import javax.validation.Valid;

import org.generation.blogpessoal.model.Postagem;
import org.generation.blogpessoal.repository.postagem_repository;
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


@RestController
@RequestMapping("/postagem")
@CrossOrigin("*")

public class PostagemController {

    @Autowired	
    private postagem_repository repositoty;



	@GetMapping
	public ResponseEntity<List<Postagem>> GetAll(){
			
	return ResponseEntity.ok(repositoty.findAll());
			
	}

	
	@GetMapping ("/{id}")
	public ResponseEntity<Postagem> Getbyid(@Valid @PathVariable long id ){
		
		return repositoty.findById(id)
				.map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
		
	}
	
	@GetMapping ("/titulo/{titulo}")
	public ResponseEntity <List<Postagem>> Getbytitulo (@Valid @PathVariable String titulo)
	
	{
		return ResponseEntity.ok(repositoty.findAllByTituloContainingIgnoreCase(titulo));
		
	}
	
	
	@PostMapping
	public ResponseEntity<Postagem> post (@Valid @RequestBody Postagem postagem)
	{
		
	 return ResponseEntity.status(HttpStatus.CREATED).body(repositoty.save(postagem));
	
	}
	
	
	@PutMapping
	public ResponseEntity<Postagem> atualizar (@Valid @RequestBody Postagem postagem)
	{	
	 return ResponseEntity.status(HttpStatus.CREATED).body(repositoty.save(postagem));
	}
	
	
	@DeleteMapping
	public void delete (@Valid @PathVariable long id)
	{
		repositoty.deleteById(id);
	
	}
	
	
}



