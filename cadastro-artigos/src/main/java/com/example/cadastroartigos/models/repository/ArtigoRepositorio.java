package com.example.cadastroartigos.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.cadastroartigos.models.entities.Artigo;

@Repository
@Transactional
public interface ArtigoRepositorio extends JpaRepository<Artigo, Integer>{

}
