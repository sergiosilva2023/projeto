package com.devssilva.projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.devssilva.projeto.dto.AcessDTO;
import com.devssilva.projeto.dto.AuthenticationDTO;
import com.devssilva.projeto.security.jwt.JwtUtils;

@Service
public class AuthService {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	public AcessDTO login(AuthenticationDTO authDto) {
		
		try {
			
		UsernamePasswordAuthenticationToken userAuth =
				new UsernamePasswordAuthenticationToken(authDto.getUsername(), authDto.getPassword());
		
		Authentication authentication = authenticationManager.authenticate(userAuth);
		
		UserDetailsImpl userAuthenticate = (UserDetailsImpl)authentication.getPrincipal();
		
		String token = jwtUtils.generateTokenFromUserDetailsImpl(userAuthenticate);
		
		AcessDTO acessDto = new AcessDTO(token);
		
		return acessDto;
		
		}catch(BadCredentialsException e) {
			//TODO LOGIN SISTEMA INVALIDO
		}
		return new AcessDTO("Acesso negado");
	}

}
