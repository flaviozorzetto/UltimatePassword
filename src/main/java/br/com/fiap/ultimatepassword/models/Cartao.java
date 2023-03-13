package br.com.fiap.ultimatepassword.models;
public class Cartao {
    private int cartao_id;
    private String nome_cartao;
    private String titular_cartao;
    private String bandeira;
    private int mes_vencimento;
    private int ano_vencimento;
    private int numero;

    public Cartao(int cartao_id, String nome_cartao, String titular_cartao, String bandeira, int mes_vencimento,
            int ano_vencimento, int numero) {
        this.cartao_id = cartao_id;
        this.nome_cartao = nome_cartao;
        this.titular_cartao = titular_cartao;
        this.bandeira = bandeira;
        this.mes_vencimento = mes_vencimento;
        this.ano_vencimento = ano_vencimento;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Cartao [cartao_id=" + cartao_id + ", nome_cartao=" + nome_cartao + ", titular_cartao=" + titular_cartao
                + ", bandeira=" + bandeira + ", mes_vencimento=" + mes_vencimento + ", ano_vencimento=" + ano_vencimento
                + ", numero=" + numero + "]";
    }

    public int getCartao_id() {
        return cartao_id;
    }
    public void setCartao_id(int cartao_id) {
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
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }

    
}
