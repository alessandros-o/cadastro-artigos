package com.example.cadastroartigos.models.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.cadastroartigos.models.entities.Usuario;

public interface UsuarioRepositorio extends PagingAndSortingRepository<Usuario, Integer>{

}
