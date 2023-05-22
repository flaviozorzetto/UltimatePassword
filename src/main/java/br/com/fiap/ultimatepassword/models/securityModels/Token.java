package br.com.fiap.ultimatepassword.models.securityModels;

public record Token(
		String token,
		String type,
		String prefix) {
}