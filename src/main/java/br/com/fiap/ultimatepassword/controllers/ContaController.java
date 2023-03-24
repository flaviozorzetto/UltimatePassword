package br.com.fiap.ultimatepassword.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.ultimatepassword.models.Conta;
import br.com.fiap.ultimatepassword.repository.ContaRepository;

@RestController
@RequestMapping("ultimatepassword/conta")
public class ContaController {
	Logger log = LoggerFactory.getLogger(ContaController.class);

	@Autowired
	ContaRepository repository;

	@GetMapping
	public List<Conta> index() {
		return repository.findAll();
	}

	@PostMapping
	public ResponseEntity<Conta> create(@RequestBody Conta conta) {
		log.info("Cadastrando conta " + conta);

		repository.save(conta);

		return ResponseEntity.status(HttpStatus.CREATED).body(conta);
	}

	@GetMapping("{id}")
	public ResponseEntity<Conta> show(@PathVariable Long id) {
		log.info("Detalhando conta " + id);
		var contaEncontrada = repository.findById(id);

		if (contaEncontrada.isEmpty())
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(contaEncontrada.get());
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Conta> destroy(@PathVariable Long id) {
		log.info("apagando conta " + id);

		var contaEncontrada = repository.findById(id);

		if (contaEncontrada.isEmpty())
			return ResponseEntity.notFound().build();

		repository.deleteById(id);

		return ResponseEntity.noContent().build();
	}

	@PutMapping("{id}")
	public ResponseEntity<Conta> update(@PathVariable Long id, @RequestBody Conta conta) {
		log.info("atualizando conta " + id);
		var contaEncontrada = repository.findById(id);

		if (contaEncontrada.isEmpty())
			return ResponseEntity.notFound().build();

		conta.setConta_id(id);
		repository.save(conta);

		return ResponseEntity.ok(conta);
	}
}
