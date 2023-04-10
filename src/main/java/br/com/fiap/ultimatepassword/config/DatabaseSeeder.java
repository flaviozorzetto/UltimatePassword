package br.com.fiap.ultimatepassword.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.ultimatepassword.models.Conta;
import br.com.fiap.ultimatepassword.repository.ContaRepository;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {
	@Autowired
	ContaRepository contaRepository;

	@Override
	public void run(String... args) throws Exception {
		contaRepository.saveAll(List.of(
				new Conta(1L, "teste_conta_1", "123"),
				new Conta(2L, "teste_conta_2", "12345"),
				new Conta(3L, "teste_conta_2", "1234567")));
	}
}
