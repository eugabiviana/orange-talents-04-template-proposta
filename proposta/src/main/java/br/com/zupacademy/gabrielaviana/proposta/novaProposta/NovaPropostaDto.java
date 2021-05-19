package br.com.zupacademy.gabrielaviana.proposta.novaProposta;

import java.math.BigDecimal;

public class NovaPropostaDto {

    private String email;
    private String nome;
    private BigDecimal salario;
    private String documento;
    private EnderecoRequest endereco;

    //Constructor

    public NovaPropostaDto(Proposta proposta) {
        this.email = email;
        this.nome = nome;
        this.salario = salario;
        this.documento = documento;
        this.endereco = endereco;
    }

    //Getters
    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public String getDocumento() {
        return documento;
    }

    public EnderecoRequest getEndereco() {
        return endereco;
    }
}
