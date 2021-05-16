package br.com.zupacademy.gabrielaviana.proposta.novaProposta;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class NovaPropostaForm {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String nome;

    @NotNull
    @Positive
    private BigDecimal salario;

    @NotBlank
    @Documento
    private String documento;

    @NotNull
    @Valid
    private EnderecoRequest endereco;

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

    //Constructors
    public NovaPropostaForm(String email, String nome, BigDecimal salario, String documento, EnderecoRequest endereco) {
        this.email = email;
        this.nome = nome;
        this.salario = salario;
        this.documento = documento;
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "NovaPropostaForm{" +
                "email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", salario=" + salario +
                ", documento='" + documento + '\'' +
                ", endereco=" + endereco +
                '}';
    }

    public Proposta paraProposta() {
        Endereco novoEndereco = endereco.paraEndereco();
        return new Proposta(email, nome, salario, documento, novoEndereco);
    }
}
