package br.com.fiap.ultimatepassword.models;

public class Despesa {
		private String nome_credencial;
		private String nome_usuario;
		private String senha;
		private String url;
		private String notas;
		public Despesa(String nome_credencial, String nome_usuario, String senha, String url, String notas) {
			this.nome_credencial = nome_credencial;
			this.nome_usuario = nome_usuario;
			this.senha = senha;
			this.url = url;
			this.notas = notas;
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
		
		@Override
		public String toString() {
			return "Despesa [nome_credencial=" + nome_credencial + ", nome_usuario=" + nome_usuario + ", senha=" + senha
					+ ", url=" + url + ", notas=" + notas + "]";
		}
		
}