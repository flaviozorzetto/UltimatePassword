package br.com.fiap.ultimatepassword.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.ultimatepassword.models.securityModels.SUsuario;

public interface SUsuarioRepository extends JpaRepository<SUsuario, Long> {

	Optional<SUsuario> findByEmail(String email);

}