package br.com.fiap.ultimatepassword.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;

import br.com.fiap.ultimatepassword.models.securityModels.SCredencial;
import br.com.fiap.ultimatepassword.models.securityModels.SUsuario;
import br.com.fiap.ultimatepassword.models.securityModels.Token;
import br.com.fiap.ultimatepassword.repository.SUsuarioRepository;
import jakarta.validation.Valid;

@Service
public class TokenService {

	@Autowired
	SUsuarioRepository susuarioRepository;

	@Value("${jwt.secret}")
	String secret;

	public Token generateToken(@Valid SCredencial scredencial) {
		Algorithm alg = Algorithm.HMAC256(secret);
		String token = JWT.create()
				.withSubject(scredencial.email())
				.withIssuer("ultimatepassword")
				.withExpiresAt(Instant.now().plus(1, ChronoUnit.HOURS))
				.sign(alg);
		return new Token(token, "JWT", "Bearer");
	}

	public SUsuario getValidateUser(String token) {
		Algorithm alg = Algorithm.HMAC256(secret);
		var email = JWT.require(alg)
				.withIssuer("ultimatepassword")
				.build()
				.verify(token)
				.getSubject();

		return susuarioRepository.findByEmail(email)
				.orElseThrow(() -> new JWTVerificationException("SUsuario invalido"));
	}

}