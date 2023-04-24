package br.com.fiap.ultimatepassword.models;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import br.com.fiap.ultimatepassword.controllers.ContaController;
import br.com.fiap.ultimatepassword.controllers.CredencialController;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor
public class Credencial {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String nome_credencial;
	@NotNull
	private String nome_usuario;
	@NotNull
	private String senha;
	@NotNull
	private String url;
	private String notas;
	@ManyToOne
	private Conta conta;

	public EntityModel<Credencial> toEntityModel() {
		return EntityModel.of(
				this,
				linkTo(methodOn(CredencialController.class).show(id)).withSelfRel(),
				linkTo(methodOn(CredencialController.class).destroy(id)).withRel("delete"),
				linkTo(methodOn(CredencialController.class).index(null, Pageable.unpaged())).withRel("all"),
				linkTo(methodOn(ContaController.class).show(this.getConta().getId())).withRel("conta"));
	}
}