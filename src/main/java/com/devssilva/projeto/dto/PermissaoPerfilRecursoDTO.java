package com.devssilva.projeto.dto;

import org.springframework.beans.BeanUtils;

import com.devssilva.projeto.entity.PermissaoPerfilRecursoEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PermissaoPerfilRecursoDTO {
	
	private Long id;
	private PerfilDTO perfil;
	private RecursoDTO recurso;
	
	public PermissaoPerfilRecursoDTO(PermissaoPerfilRecursoEntity permissaoPerfilRecurso) {
		BeanUtils.copyProperties(permissaoPerfilRecurso, this);
		if(permissaoPerfilRecurso != null && permissaoPerfilRecurso.getRecurso() != null) {
			this.recurso = new RecursoDTO(permissaoPerfilRecurso.getRecurso());
		}
		if(permissaoPerfilRecurso != null && permissaoPerfilRecurso.getRecurso() != null) {
			this.perfil = new PerfilDTO(permissaoPerfilRecurso.getPerfil());
		}
	}

}
