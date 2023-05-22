package br.com.fiap.ultimatepassword.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@Autowired
	PagedResourcesAssembler<Object> assembler;

	@GetMapping
	public PagedModel<EntityModel<Object>> index(@RequestParam(required = false) String url,
			@PageableDefault(size = 5) Pageable pageable) {

		Page<Credencial> credenciais = (url == null) ? repository.findAll(pageable)
				: repository.findByUrlContaining(url, pageable);

		return assembler.toModel(credenciais.map(Credencial::toEntityModel));
	}

	@PostMapping
	public ResponseEntity<Object> create(@RequestBody @Valid Credencial credencial) {
		log.info("Cadastrando credencial " + credencial);

		repository.save(credencial);

		return ResponseEntity
				.created(credencial.toEntityModel().getRequiredLink("self").toUri()).body(credencial.toEntityModel());
	}

	@GetMapping("{id}")
	public EntityModel<Credencial> show(@PathVariable Long id) {
		log.info("Detalhando credencial " + id);
		return getCredencial(id).toEntityModel();
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Credencial> destroy(@PathVariable Long id) {
		log.info("apagando credencial " + id);
		var cartao = getCredencial(id);

		repository.delete(cartao);

		return ResponseEntity.noContent().build();
	}

	@PutMapping("{id}")
	public EntityModel<Credencial> update(@PathVariable Long id, @Valid @RequestBody Credencial credencial) {
		log.info("atualizando credencial " + id);
		getCredencial(id);

		credencial.setId(id);
		repository.save(credencial);

		return credencial.toEntityModel();
	}

	private Credencial getCredencial(Long id) {
		return repository.findById(id).orElseThrow(() -> new RestNotFoundException("Não foi encontrado uma credencial"));
	}

}
