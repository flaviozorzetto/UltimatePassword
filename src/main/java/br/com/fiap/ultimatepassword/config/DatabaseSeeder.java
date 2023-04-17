package br.com.fiap.ultimatepassword.config;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.ultimatepassword.models.Conta;
import br.com.fiap.ultimatepassword.models.Credencial;
import br.com.fiap.ultimatepassword.repository.ContaRepository;
import br.com.fiap.ultimatepassword.repository.CredencialRepository;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {
	@Autowired
	ContaRepository contaRepository;

	@Autowired
	CredencialRepository credencialRepository;

	@Override
	public void run(String... args) throws Exception {
		Conta c1 = new Conta(1L, "teste_conta_1", passGen());
		Conta c2 = new Conta(2L, "teste_conta_2", passGen());
		Conta c3 = new Conta(3L, "teste_conta_2", passGen());
		contaRepository.saveAll(List.of(c1, c2, c3));

		credencialRepository.saveAll(
				List.of(
						GenerateBuilder("hotmail", c1),
						GenerateBuilder("gmail", c1),
						GenerateBuilder("azure", c1),
						GenerateBuilder("twitch", c1),
						GenerateBuilder("twitch", c1),
						GenerateBuilder("twitch", c1),
						GenerateBuilder("youtube", c1),
						GenerateBuilder("uol", c1),
						GenerateBuilder("outlook", c1)));
	}

	private Credencial GenerateBuilder(String prefixDesc, Conta c) {
		return Credencial.builder()
				.nome_credencial("Conta " + prefixDesc)
				.nome_usuario("teste@" + prefixDesc + ".com")
				.senha(passGen())
				.url(prefixDesc + ".com")
				.notas("Esta é a credencial relacionada a conta do " + prefixDesc)
				.conta(c)
				.build();
	}

	private String passGen() {
		return (String) new Random().ints(10, 48, 95).mapToObj(i -> String.valueOf((char) i))
				.collect(Collectors.joining());
	}
}
