package com.example.cadastroartigos.models.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.cadastroartigos.models.entities.Categoria;

public interface CategoriaRepositorio extends PagingAndSortingRepository<Categoria, Integer>{

}
