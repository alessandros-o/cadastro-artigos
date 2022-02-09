package com.example.cadastroartigos.controllers;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.cadastroartigos.models.entities.Artigo;
import com.example.cadastroartigos.models.entities.Categoria;
import com.example.cadastroartigos.models.repository.CategoriaRepositorio;
import com.example.cadastroartigos.service.ArtigoService;

@Controller
public class ArtigoController {
	
	@Autowired
	private ArtigoService artigoService;
	
	@Autowired
	private CategoriaRepositorio cr;
		 	
	
	@GetMapping("/get")
	public String obterArtigos(Artigo artigo, Model model) {
		List<Artigo> artigos = artigoService.getArtigos();
		model.addAttribute("artigos", artigos);
		
		List<Categoria> categorias = (List<Categoria>) cr.findAll();
		model.addAttribute("categorias", categorias);
		
		return "artigo/artigo";
		
		
	}
	
	@RequestMapping(value= "/{id}", method=RequestMethod.POST)
	public String upLoadMultipleFiles(@RequestParam("files") MultipartFile[] files, @PathVariable("id") int id, @RequestParam("categorias") int idCategoria) {
		for(MultipartFile file:files) {
			artigoService.salvarArquivo(file, id, idCategoria);
			
		}
		
		return "redirect:/{id}";
	}
	
	@GetMapping("/downloadFile/{artigoId}")
	public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Integer artigoId){
		Artigo artigo = artigoService.getArtigo(artigoId).get();
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(artigo.getDocType()))
				.header(org.springframework.http.HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\""+artigo.getTitulo()+"")
				.body(new ByteArrayResource(artigo.getData()));
	}
	
	@RequestMapping("/deletarArtigo")
	public String excluirArtigo(int id) {
		artigoService.deletarArtigo(id);
		return "redirect:/get";
	}
	
}
