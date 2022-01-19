package com.example.cadastroartigos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cadastroartigos.models.entities.Categoria;
import com.example.cadastroartigos.models.repository.CategoriaRepositorio;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepositorio categoriaRepositorio;
	
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public @ResponseBody Categoria salvarCategoria(@Validated Categoria categoria) {
		categoriaRepositorio.save(categoria);
		return categoria;
	}
	
	@GetMapping
	public Iterable<Categoria> obterCategoria(){
		return categoriaRepositorio.findAll();
	}
	
	@DeleteMapping(path = "/{id}")
	public void excluirCategoria(@PathVariable int id) {
		categoriaRepositorio.deleteById(id);
	}

}
