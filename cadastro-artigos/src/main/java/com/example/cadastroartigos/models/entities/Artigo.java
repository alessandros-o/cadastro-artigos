package com.example.cadastroartigos.models.entities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Artigo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String titulo;
	
	@ManyToOne
	private Usuario usuario;
	
	@ManyToOne
	private Categoria categoria;
	
	public Artigo() {
		
	}
	
	public Artigo(String titulo, Usuario usuario, Categoria categoria) {
		super();
		this.titulo = titulo;
		this.usuario = usuario;
		this.categoria = categoria;
	}


	public void upload(String pasta, String nomeDoArquivo, InputStream arquivoCarregado) {
		
		String caminhoArquivo = pasta + "/" + nomeDoArquivo;
		File novoArquivo = new File(caminhoArquivo);
		
		try {
			FileOutputStream saida = new FileOutputStream(novoArquivo);
			copiar(arquivoCarregado, saida);
		} catch (Exception e) {
			
		}
		
	}
	
	public void copiar(InputStream origem, OutputStream destino) {
		int bite = 0; 
		byte[] tamanhoMaximo = new byte[1024 * 8];
		
		try {
			while((bite = origem.read(tamanhoMaximo)) >= 0) {
				destino.write(tamanhoMaximo, 0, bite);
			}
			
		} catch (Exception e) {
			
		}
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	

}
