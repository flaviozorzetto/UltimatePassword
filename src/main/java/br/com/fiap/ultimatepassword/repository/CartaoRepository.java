package br.com.fiap.ultimatepassword.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.ultimatepassword.models.Cartao;

public interface CartaoRepository extends JpaRepository<Cartao, Long> {

}
