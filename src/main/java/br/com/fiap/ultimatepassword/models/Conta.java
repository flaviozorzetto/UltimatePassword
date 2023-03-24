package br.com.fiap.ultimatepassword.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Conta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long conta_id;
	private String usuario;
	private String senha;

	protected Conta() {}

	public Conta(Long conta_id, String usuario, String senha) {
		this.conta_id = conta_id;
		this.usuario = usuario;
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Conta [conta_id=" + conta_id + ", usuario=" + usuario + ", senha=" + senha + "]";
	}

	public Long getConta_id() {
		return conta_id;
	}

	public void setConta_id(Long conta_id) {
		this.conta_id = conta_id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
