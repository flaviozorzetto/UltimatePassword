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

import br.com.fiap.ultimatepassword.models.Credencial;
import br.com.fiap.ultimatepassword.repository.CredencialRepository;

@RestController
@RequestMapping("ultimatepassword/credencial")
public class CredencialController {
	Logger log = LoggerFactory.getLogger(CredencialController.class);

	@Autowired
	CredencialRepository repository;

	@GetMapping
	public List<Credencial> index() {
		return repository.findAll();
	}

	@PostMapping
	public ResponseEntity<Credencial> create(@RequestBody Credencial credencial) {
		log.info("Cadastrando credencial " + credencial);

		repository.save(credencial);

		return ResponseEntity.status(HttpStatus.CREATED).body(credencial);
	}

	@GetMapping("{id}")
	public ResponseEntity<Credencial> show(@PathVariable Long id) {
		log.info("Detalhando credencial " + id);
		var credencialEncontrado = repository.findById(id);

		if (credencialEncontrado.isEmpty())
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(credencialEncontrado.get());
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Credencial> destroy(@PathVariable Long id) {
		log.info("apagando credencial " + id);

		var credencialEncontrado = repository.findById(id);

		if (credencialEncontrado.isEmpty())
			return ResponseEntity.notFound().build();

		repository.deleteById(id);

		return ResponseEntity.noContent().build();
	}

	@PutMapping("{id}")
	public ResponseEntity<Credencial> update(@PathVariable Long id, @RequestBody Credencial credencial) {
		log.info("atualizando credencial " + id);
		var credencialEncontrado = repository.findById(id);

		if (credencialEncontrado.isEmpty())
			return ResponseEntity.notFound().build();

		credencial.setCredencial_id(id);
		repository.save(credencial);

		return ResponseEntity.ok(credencial);
	}

}
