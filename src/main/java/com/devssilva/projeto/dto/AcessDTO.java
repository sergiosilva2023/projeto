package com.devssilva.projeto.dto;

public class AcessDTO {
	
	private String token;
	
	//TODO implementar retornar o usuario e as liberações (authorities)

	public AcessDTO(String token) {
		super();
		this.token = token;
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
