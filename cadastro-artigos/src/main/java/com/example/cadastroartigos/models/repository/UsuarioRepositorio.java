package com.example.cadastroartigos.models.repository;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.cadastroartigos.models.entities.Usuario;

@Repository
@Transactional
public interface UsuarioRepositorio extends CrudRepository<Usuario, Integer>{
	Usuario findById(int id);
}
