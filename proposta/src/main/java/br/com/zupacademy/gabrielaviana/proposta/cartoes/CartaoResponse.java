package br.com.zupacademy.gabrielaviana.proposta.cartoes;

import javax.persistence.OneToOne;
import java.time.LocalDateTime;

public class CartaoResponse {

    private Long id;
    private String titular;
    private LocalDateTime emitidoEm;
    private Integer limite;
    private String idProposta;

    //Constructor
    public CartaoResponse(Long id, String titular, LocalDateTime emitidoEm, Integer limite, String idProposta) {
        this.id = id;
        this.titular = titular;
        this.emitidoEm = emitidoEm;
        this.limite = limite;
        this.idProposta = idProposta;
    }

    //Getters
    public Long getId() {
        return id;
    }

    public String getTitular() {
        return titular;
    }

    public LocalDateTime getEmitidoEm() {
        return emitidoEm;
    }

    public Integer getLimite() {
        return limite;
    }

    public String getIdProposta() {
        return idProposta;
    }

    //toString
    @Override
    public String toString() {
        return "CartaoResponse{" +
                "id=" + id +
                ", titular='" + titular + '\'' +
                ", emitidoEm=" + emitidoEm +
                ", limite=" + limite +
                ", idProposta='" + idProposta + '\'' +
                '}';
    }
}
