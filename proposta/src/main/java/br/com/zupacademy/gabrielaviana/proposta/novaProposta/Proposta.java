package br.com.zupacademy.gabrielaviana.proposta.novaProposta;

import br.com.zupacademy.gabrielaviana.proposta.cartoes.Cartao;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
public class Proposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    @Embedded
    private Endereco endereco;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne
    private Cartao cartao;


//Constructors

    /**
     * @deprecated apenas para o uso do hibernate
     */
   @Deprecated
    Proposta(){

    }

    public Proposta(String email, String nome, BigDecimal salario, String documento, Endereco endereco) {
        this.email = email;
        this.nome = nome;
        this.salario = salario;
        this.documento = documento;
        this.endereco = endereco;
    }

    public Proposta(String email, String nome, BigDecimal salario, String documento, EnderecoRequest endereco) {
    }

    public Proposta(Proposta proposta) {
       this.id = getId();
    }

    //Getters
    public Long getId() {
       return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setStatus(Status status) {
       this.status = status;
    }

    public Cartao getCartao() { return cartao; }

    //Setter

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }
}
