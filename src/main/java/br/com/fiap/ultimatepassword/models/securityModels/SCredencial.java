package br.com.fiap.ultimatepassword.models.securityModels;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

public record SCredencial(String email, String senha) {

	public Authentication toAuthentication() {
		return new UsernamePasswordAuthenticationToken(email, senha);
	}

}
