package br.com.zupacademy.gabrielaviana.proposta.cartoes;

import br.com.zupacademy.gabrielaviana.proposta.novaProposta.Proposta;
import br.com.zupacademy.gabrielaviana.proposta.novaProposta.PropostaRepository;

import javax.persistence.OneToOne;
import java.time.LocalDateTime;

public class CartaoResponse {

    private String id;
    private String titular;
    private Integer limite;
    private Long idProposta;

    //Constructor
    public CartaoResponse(String id, String titular, Integer limite, Long idProposta) {
        this.id = id;
        this.titular = titular;
        this.limite = limite;
        this.idProposta = idProposta;
    }

    //Getters
    public String getNumeroCartao() {
        return id;
    }

    public String getTitular() {
        return titular;
    }

    public Integer getLimite() {
        return limite;
    }

    public Long getIdProposta() {
        return idProposta;
    }


    public Cartao paraCartao(PropostaRepository propostaRepository) {
        Proposta proposta = propostaRepository.findById(idProposta).get();
        return new Cartao (this.id, this.titular, this.limite, proposta);
    }
}
