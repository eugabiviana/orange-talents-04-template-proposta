package br.com.zupacademy.gabrielaviana.proposta.cartoes;

import br.com.zupacademy.gabrielaviana.proposta.novaProposta.Proposta;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name="cartao")
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numeroCartao;
    @NotNull
    private LocalDateTime emitidoEm = LocalDateTime.now();
    @NotBlank
    private String titular;
    @NotNull
    private Integer limite;

    @NotNull @OneToOne(mappedBy = "cartao")
    private Proposta proposta;

    //Constructors
    /**
     * @deprecated apenas para uso do framework
     */
    @Deprecated
    public Cartao(){

    }

    public Cartao(String numeroCartao, String titular, Integer limite, Proposta proposta) {
        this.numeroCartao = numeroCartao;
        this.titular = titular;
        this.limite = limite;
        this.proposta = proposta;
    }

    //Getters

    public Long getId() {
        return id;
    }

    public LocalDateTime getEmitidoEm() {
        return emitidoEm;
    }

    public String getTitular() {
        return titular;
    }

    public Integer getLimite() {
        return limite;
    }

    public Proposta getProposta() {
        return proposta;
    }
}
