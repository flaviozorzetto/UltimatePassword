package br.com.fiap.ultimatepassword.models;

public class Conta {
    private int conta_id;
    private String usuario;
    private String senha;
    
    public Conta(int conta_id, String usuario, String senha) {
        this.conta_id = conta_id;
        this.usuario = usuario;
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Conta [conta_id=" + conta_id + ", usuario=" + usuario + ", senha=" + senha + "]";
    }
    
    public int getConta_id() {
        return conta_id;
    }
    public void setConta_id(int conta_id) {
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
