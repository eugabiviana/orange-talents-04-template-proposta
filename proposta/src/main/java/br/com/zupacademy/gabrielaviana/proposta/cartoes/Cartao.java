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
    private Long Id;
    @NotNull
    private LocalDateTime emitidoEm;
    @NotBlank
    private String titular;
    @NotNull
    private Integer limite;

    @NotNull @OneToOne @JoinColumn(name="proposta")
    private Proposta proposta;

    //Constructors
    /**
     * @deprecated apenas para uso do framework
     */
    @Deprecated
    public Cartao(){

    }

    public Cartao(Long id, LocalDateTime emitidoEm, String titular, Integer limite, Proposta proposta) {
        Id = id;
        this.emitidoEm = emitidoEm;
        this.titular = titular;
        this.limite = limite;
        this.proposta = proposta;
    }

    //Getters

    public Long getId() {
        return Id;
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
