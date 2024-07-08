package com.devssilva.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devssilva.projeto.dto.PerfilUsuarioDTO;
import com.devssilva.projeto.entity.PerfilUsuarioEntity;
import com.devssilva.projeto.repository.PerfilUsuarioRepository;

@Service
public class PerfilUsuarioService {
	
	@Autowired
	private PerfilUsuarioRepository perfilUsuarioRepository;
	
	public List<PerfilUsuarioDTO> listarTodos(){
		List<PerfilUsuarioEntity> perfilUsuarios = perfilUsuarioRepository.findAll();
		return perfilUsuarios.stream().map(PerfilUsuarioDTO::new).toList();
	}
	
	public PerfilUsuarioDTO buscarPorId(Long id) {
		return new PerfilUsuarioDTO(perfilUsuarioRepository.findById(id).get());
		
	}
	
	public void inserir(PerfilUsuarioDTO perfilUsuario) {
		PerfilUsuarioEntity perfilUsuarioEntity = new PerfilUsuarioEntity(perfilUsuario);
		perfilUsuarioRepository.save(perfilUsuarioEntity);
	}
	
	public PerfilUsuarioDTO alterar(PerfilUsuarioDTO perfilUsuario) {
		PerfilUsuarioEntity perfilUsuarioEntity = new PerfilUsuarioEntity(perfilUsuario);
		return new PerfilUsuarioDTO(perfilUsuarioRepository.save(perfilUsuarioEntity));
	}
	
	public void excluir(Long id) {
		PerfilUsuarioEntity perfilUsuario = perfilUsuarioRepository.findById(id).get();
		perfilUsuarioRepository.delete(perfilUsuario);
	}
	

}
