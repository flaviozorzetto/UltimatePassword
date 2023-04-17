package br.com.fiap.ultimatepassword.models;

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
}