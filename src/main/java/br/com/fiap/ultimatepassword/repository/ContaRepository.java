package br.com.fiap.ultimatepassword.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.ultimatepassword.models.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {

}
