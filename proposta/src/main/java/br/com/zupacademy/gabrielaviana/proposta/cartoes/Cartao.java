package br.com.zupacademy.gabrielaviana.proposta.cartoes;

import br.com.zupacademy.gabrielaviana.proposta.bloqueio.BloqueioModel;
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
    private String id;
    private String numeroCartao;
    @NotNull
    private LocalDateTime emitidoEm = LocalDateTime.now();
    @NotBlank
    private String titular;
    @NotNull
    private Integer limite;

    @NotNull @OneToOne(mappedBy = "cartao")
    private Proposta proposta;

    @Enumerated(value = EnumType.STRING)
    private StatusCartao status = StatusCartao.ATIVO;

    @OneToOne(mappedBy = "cartaoBloqueado", cascade = CascadeType.MERGE)
    private BloqueioModel bloqueio;


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

    public boolean verificaBloqueado() {
        return this.status.equals(StatusCartao.BLOQUEADO);
    }

    public void setBloqueio(BloqueioModel bloqueio) {
        this.bloqueio = bloqueio;
        this.status = StatusCartao.BLOQUEADO;

    }

    //Getters
    public String getId() {
        return id;
    }

    public String getNumeroCartao() {
        return numeroCartao;
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

    public StatusCartao getStatus() {
        return status;
    }

    public BloqueioModel getBloqueio() {
        return bloqueio;
    }
}
