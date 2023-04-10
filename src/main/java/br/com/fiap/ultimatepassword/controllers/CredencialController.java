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

import br.com.fiap.ultimatepassword.exceptions.RestNotFoundException;
import br.com.fiap.ultimatepassword.models.Credencial;
import br.com.fiap.ultimatepassword.repository.CredencialRepository;
import jakarta.validation.Valid;

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
	public ResponseEntity<Credencial> create(@RequestBody @Valid Credencial credencial) {
		log.info("Cadastrando credencial " + credencial);

		repository.save(credencial);

		return ResponseEntity.status(HttpStatus.CREATED).body(credencial);
	}

	@GetMapping("{id}")
	public ResponseEntity<Credencial> show(@PathVariable Long id) {
		log.info("Detalhando credencial " + id);

		var credencial = getCredencial(id);

		return ResponseEntity.ok(credencial);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Credencial> destroy(@PathVariable Long id) {
		log.info("apagando credencial " + id);

		var cartao = getCredencial(id);

		repository.delete(cartao);

		return ResponseEntity.noContent().build();
	}

	@PutMapping("{id}")
	public ResponseEntity<Credencial> update(@PathVariable Long id, @Valid @RequestBody Credencial credencial) {
		log.info("atualizando credencial " + id);
		getCredencial(id);

		credencial.setId(id);
		repository.save(credencial);

		return ResponseEntity.ok(credencial);
	}

	private Credencial getCredencial(Long id) {
		return repository.findById(id).orElseThrow(() -> new RestNotFoundException("Não foi encontrado uma credencial"));
	}

}
