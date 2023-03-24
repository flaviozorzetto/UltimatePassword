package br.com.fiap.ultimatepassword.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.ultimatepassword.models.Credencial;

public interface CredencialRepository extends JpaRepository<Credencial, Long> {
	
}
