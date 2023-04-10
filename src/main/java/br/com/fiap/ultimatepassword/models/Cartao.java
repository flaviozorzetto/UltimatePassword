package br.com.fiap.ultimatepassword.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Cartao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String nome_cartao;
	@NotNull
	private String titular_cartao;
	@NotNull
	private String bandeira;
	@NotNull
	@Min(value = 1, message = "O mês deve ser entre 1-12")
	@Max(value = 12, message = "O mês deve ser entre 1-12")
	private int mes_vencimento;
	@NotNull
	@Min(value = 2023, message = "O ano deve ser maior ou igual a 2023")
	private int ano_vencimento;
	@NotNull
	private Long numero;
	@NotNull
	@Min(value = 100, message = "O cvv deve ser maior ou igual a 100")
	@Max(value = 9999, message = "O cvv deve ser menor ou igual a 9999")
	private int cvv;
	@ManyToOne
	private Conta conta;
}
