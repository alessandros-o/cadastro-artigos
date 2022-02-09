package com.example.cadastroartigos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.cadastroartigos.models.entities.Categoria;
import com.example.cadastroartigos.models.repository.CategoriaRepositorio;

@Controller
public class CategoriaController {
	
	@Autowired
	private CategoriaRepositorio categoriaRepositorio;
	
	
	@GetMapping("/categorias")
	public String obterCategoria(Categoria categoria, Model model){
		List<Categoria> categorias = (List<Categoria>) categoriaRepositorio.findAll();
		model.addAttribute("categorias", categorias);
		return "categoria/categoria";
	}
	
	
	@PostMapping("/cadastroCategoria")
	public String salvarCategoria(Categoria categoria) {
		categoriaRepositorio.save(categoria);
		return "redirect:/categorias";
	}
	
	@RequestMapping("/deletarCategoria")
	public String excluirCategoria(int id) {
		Categoria categoria = categoriaRepositorio.findById(id);
		categoriaRepositorio.delete(categoria);
		return "redirect:/categorias";
	}
	

}
