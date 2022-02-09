package com.example.cadastroartigos.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.cadastroartigos.models.entities.Artigo;
import com.example.cadastroartigos.models.entities.Categoria;
import com.example.cadastroartigos.models.entities.Usuario;
import com.example.cadastroartigos.models.repository.CategoriaRepositorio;
import com.example.cadastroartigos.models.repository.UsuarioRepositorio;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioRepositorio usuarios;
	
	@Autowired
	private CategoriaRepositorio cr;
		
	
	@GetMapping("/cadastroUsuario")
	public String obterUsuario(Model model) { 
		List<Usuario> usuario = (List<Usuario>) usuarios.findAll();
		model.addAttribute("usuario", usuario);
		return "usuario";
	}
	
	
	@PostMapping("/cadastroUsuario")
	public String salvar(Usuario usuario) {
		usuarios.save(usuario);
		return "redirect:/cadastroUsuario";
	}
	
	@RequestMapping("/{id}")
	public ModelAndView cadArtigoUse(@PathVariable("id") int id) {
		Usuario usuario = usuarios.findById(id);
		List<Categoria> categorias = (List<Categoria>) cr.findAll();
		List<Artigo> artigos = usuario.getArtigos();
		
		ModelAndView mv = new ModelAndView("artigo/artigo");
		mv.addObject("usuario", usuario);
		mv.addObject("categorias", categorias);
		mv.addObject("artigos", artigos);
		
		System.out.println("usuario" + usuario);
		return mv;
	}
	
		 
	@RequestMapping("/deletar")
	public String excluirUsuario(int id) {
		Usuario usuario = usuarios.findById(id);
		usuarios.delete(usuario);
		return "redirect:/cadastroUsuario";
	}

}
