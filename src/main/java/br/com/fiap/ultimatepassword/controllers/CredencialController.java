package br.com.fiap.ultimatepassword.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.ultimatepassword.models.Despesa;

@RestController
public class CredencialController {

	@GetMapping("/api/credencial")
	public Despesa show() {
		return new Despesa("Conta gmail", "teste@gmail.com", "Teste123", "gmail.com", "Esta é a credencial relacionada a conta do gmail teste");
	}
	
}
