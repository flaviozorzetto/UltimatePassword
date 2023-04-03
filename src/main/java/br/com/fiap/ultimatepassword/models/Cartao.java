package br.com.fiap.ultimatepassword.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
public class Cartao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cartao_id;
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

	protected Cartao() {
	}

	public Cartao(Long cartao_id, String nome_cartao, String titular_cartao, String bandeira, int mes_vencimento,
			int ano_vencimento, int cvv) {
		this.cartao_id = cartao_id;
		this.nome_cartao = nome_cartao;
		this.titular_cartao = titular_cartao;
		this.bandeira = bandeira;
		this.mes_vencimento = mes_vencimento;
		this.ano_vencimento = ano_vencimento;
		this.cvv = cvv;
	}

	@Override
	public String toString() {
		return "Cartao [cartao_id=" + cartao_id + ", nome_cartao=" + nome_cartao + ", titular_cartao=" + titular_cartao
				+ ", bandeira=" + bandeira + ", mes_vencimento=" + mes_vencimento + ", ano_vencimento=" + ano_vencimento
				+ ", numero=" + numero + ", cvv=" + cvv + "]";
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Long getCartao_id() {
		return cartao_id;
	}

	public void setCartao_id(Long cartao_id) {
		this.cartao_id = cartao_id;
	}

	public String getNome_cartao() {
		return nome_cartao;
	}

	public void setNome_cartao(String nome_cartao) {
		this.nome_cartao = nome_cartao;
	}

	public String getTitular_cartao() {
		return titular_cartao;
	}

	public void setTitular_cartao(String titular_cartao) {
		this.titular_cartao = titular_cartao;
	}

	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

	public int getMes_vencimento() {
		return mes_vencimento;
	}

	public void setMes_vencimento(int mes_vencimento) {
		this.mes_vencimento = mes_vencimento;
	}

	public int getAno_vencimento() {
		return ano_vencimento;
	}

	public void setAno_vencimento(int ano_vencimento) {
		this.ano_vencimento = ano_vencimento;
	}

	public int getcvv() {
		return cvv;
	}

	public void setcvv(int cvv) {
		this.cvv = cvv;
	}

}
