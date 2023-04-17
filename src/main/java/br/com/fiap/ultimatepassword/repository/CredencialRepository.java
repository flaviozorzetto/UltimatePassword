package br.com.fiap.ultimatepassword.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.ultimatepassword.models.Credencial;

public interface CredencialRepository extends JpaRepository<Credencial, Long> {

	Page<Credencial> findByUrlContaining(String url, Pageable pageable);
	
}
