package br.com.zupacademy.gabrielaviana.proposta.carteira;

import br.com.zupacademy.gabrielaviana.proposta.cartoes.Cartao;

import javax.validation.constraints.NotBlank;

public class CarteiraResponse {

    private String resultado;
    private @NotBlank String id;

    public CarteiraResponse(String resultado, @NotBlank String id) {

        this.resultado = resultado;
        this.id = id;
    }

    public String getResultado() {
        return resultado;
    }

    public String getId() {
        return id;
    }

    public Carteira toModel(CarteiraRequest request, Cartao cartao) {
        return new Carteira(id, request.getEmail(), request.getCarteira(), cartao);
    }

}
