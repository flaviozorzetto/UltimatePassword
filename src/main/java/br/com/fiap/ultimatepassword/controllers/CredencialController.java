package br.com.fiap.ultimatepassword.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.ultimatepassword.models.Credencial;

@RestController
public class CredencialController {

	@GetMapping("/api/credencial")
	public Credencial show() {
		return new Credencial(1, "Conta gmail", "teste@gmail.com", "Teste123", "gmail.com", "Esta é a credencial relacionada a conta do gmail teste");
	}
	
}
