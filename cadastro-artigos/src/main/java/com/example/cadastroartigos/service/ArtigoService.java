package com.example.cadastroartigos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.cadastroartigos.models.entities.Artigo;
import com.example.cadastroartigos.models.entities.Categoria;
import com.example.cadastroartigos.models.entities.Usuario;
import com.example.cadastroartigos.models.repository.ArtigoRepositorio;
import com.example.cadastroartigos.models.repository.CategoriaRepositorio;
import com.example.cadastroartigos.models.repository.UsuarioRepositorio;

@Service
public class ArtigoService {
	
	@Autowired
	private ArtigoRepositorio artigoRepositorio;
	
	@Autowired
	private UsuarioRepositorio ur;
	
	@Autowired
	private CategoriaRepositorio cr;
	
	public Artigo salvarArquivo(MultipartFile file, int id, int idCategoria) {
		String nomeArtigo = file.getOriginalFilename();
		Usuario usuarios = ur.findById(id);
		Categoria categorias = cr.findById(idCategoria);
		try {
			
			Artigo artigo = new Artigo(nomeArtigo, file.getContentType(), file.getBytes(), usuarios, categorias);
			return artigoRepositorio.save(artigo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Optional<Artigo> getArtigo(Integer artigoId) {
		return artigoRepositorio.findById(artigoId);
	}
	public List<Artigo> getArtigos(){
		return artigoRepositorio.findAll();
	}
	
	public void deletarArtigo(Integer artigoId) {
		artigoRepositorio.deleteById(artigoId);
	}

}
