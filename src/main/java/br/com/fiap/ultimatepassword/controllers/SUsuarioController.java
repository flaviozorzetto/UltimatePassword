package br.com.fiap.ultimatepassword.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.ultimatepassword.models.securityModels.SCredencial;
import br.com.fiap.ultimatepassword.models.securityModels.SUsuario;
import br.com.fiap.ultimatepassword.repository.SUsuarioRepository;
import jakarta.validation.Valid;

@RestController
public class SUsuarioController {

	@Autowired
	SUsuarioRepository repository;

	@Autowired
	AuthenticationManager manager;

	@Autowired
	PasswordEncoder encoder;

	@PostMapping("/ultimatepassword/registrar")
	public ResponseEntity<SUsuario> registrar(@RequestBody @Valid SUsuario susuario) {
		susuario.setSenha(encoder.encode(susuario.getSenha()));
		repository.save(susuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(susuario);
	}

	@PostMapping("/ultimatepassword/login")
	public ResponseEntity<Object> login(@RequestBody @Valid SCredencial scredencial) {
		manager.authenticate(scredencial.toAuthentication());
		return ResponseEntity.ok().build();
	}

}