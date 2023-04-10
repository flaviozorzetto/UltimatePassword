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
import br.com.fiap.ultimatepassword.models.Cartao;
import br.com.fiap.ultimatepassword.repository.CartaoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("ultimatepassword/cartao")
public class CartaoController {
	Logger log = LoggerFactory.getLogger(CartaoController.class);

	@Autowired
	CartaoRepository repository;

	@GetMapping
	public List<Cartao> index() {
		return repository.findAll();
	}

	@PostMapping
	public ResponseEntity<Cartao> create(@RequestBody @Valid Cartao cartao) {
		log.info("Cadastrando cartao " + cartao);

		repository.save(cartao);

		return ResponseEntity.status(HttpStatus.CREATED).body(cartao);
	}

	@GetMapping("{id}")
	public ResponseEntity<Cartao> show(@PathVariable Long id) {
		log.info("detalhando cartão " + id);

		var cartao = getCartao(id);

		return ResponseEntity.ok(cartao);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Cartao> destroy(@PathVariable Long id) {
		log.info("apagando cartão " + id);

		var cartao = getCartao(id);

		repository.delete(cartao);

		return ResponseEntity.noContent().build();
	}

	@PutMapping("{id}")
	public ResponseEntity<Cartao> update(@PathVariable Long id, @Valid @RequestBody Cartao cartao) {
		log.info("atualizando cartão " + id);
		getCartao(id);

		cartao.setId(id);
		repository.save(cartao);

		return ResponseEntity.ok(cartao);
	}

	private Cartao getCartao(Long id) {
		return repository.findById(id).orElseThrow(() -> new RestNotFoundException("Cartão nao encontrado"));
	}

}
