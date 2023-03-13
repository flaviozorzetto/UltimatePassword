package br.com.fiap.ultimatepassword.models;

public class Credencial {
		private int credencial_id;
		private String nome_credencial;
		private String nome_usuario;
		private String senha;
		private String url;
		private String notas;
		public Credencial(int credencial_id, String nome_credencial, String nome_usuario, String senha, String url, String notas) {
			this.credencial_id = credencial_id;
			this.nome_credencial = nome_credencial;
			this.nome_usuario = nome_usuario;
			this.senha = senha;
			this.url = url;
			this.notas = notas;
		}
		public int getCredencial_id() {
			return credencial_id;
		}
		public void setCredencial_id(int credencial_id) {
			this.credencial_id = credencial_id;
		}
		public String getNome_credencial() {
			return nome_credencial;
		}
		public void setNome_credencial(String nome_credencial) {
			this.nome_credencial = nome_credencial;
		}
		public String getNome_usuario() {
			return nome_usuario;
		}
		public void setNome_usuario(String nome_usuario) {
			this.nome_usuario = nome_usuario;
		}
		public String getSenha() {
			return senha;
		}
		public void setSenha(String senha) {
			this.senha = senha;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getNotas() {
			return notas;
		}
		public void setNotas(String notas) {
			this.notas = notas;
		}
		
}