package com.example.cadastroartigos.models.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.cadastroartigos.models.entities.Categoria;

@Repository
@Transactional
public interface CategoriaRepositorio extends CrudRepository<Categoria, Integer>{
	Categoria findById(int id);
}
