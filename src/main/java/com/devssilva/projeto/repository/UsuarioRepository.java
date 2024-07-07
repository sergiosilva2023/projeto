package com.devssilva.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devssilva.projeto.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{
	
}
