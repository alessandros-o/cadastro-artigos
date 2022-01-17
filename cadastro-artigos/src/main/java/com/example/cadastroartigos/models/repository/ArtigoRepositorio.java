package com.example.cadastroartigos.models.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.cadastroartigos.models.entities.Artigo;

public interface ArtigoRepositorio extends PagingAndSortingRepository<Artigo, Integer>{

}
