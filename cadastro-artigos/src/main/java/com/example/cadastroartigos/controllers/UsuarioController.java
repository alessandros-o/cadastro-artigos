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

import com.example.cadastroartigos.models.entities.Usuario;
import com.example.cadastroartigos.models.repository.UsuarioRepositorio;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public @ResponseBody Usuario salvarUsuario(@Validated Usuario usuario) {
		usuarioRepositorio.save(usuario);
		return usuario;
	}
	
	@GetMapping
	public Iterable<Usuario> obterUsuario(){
		return usuarioRepositorio.findAll();
	}
	
	@DeleteMapping(path = "/{id}")
	public void excluirUsuario(@PathVariable int id) {
		usuarioRepositorio.deleteById(id);
	}

}
