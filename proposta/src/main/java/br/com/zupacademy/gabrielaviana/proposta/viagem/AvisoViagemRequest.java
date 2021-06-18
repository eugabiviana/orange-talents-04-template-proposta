package br.com.zupacademy.gabrielaviana.proposta.viagem;

import br.com.zupacademy.gabrielaviana.proposta.cartoes.Cartao;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class AvisoViagemRequest {

    @NotBlank
    private String destino;

    @Future
    private LocalDate dataTerminoViagem;

    public AvisoViagemRequest(@NotBlank String destino, @Future LocalDate dataTerminoViagem) {

        this.destino = destino;
        this.dataTerminoViagem = dataTerminoViagem;
    }

    public String getDestino() {
        return destino;
    }

    public LocalDate getDataTerminoViagem() {
        return dataTerminoViagem;
    }

    public AvisoViagem toModel(Cartao cartao, String ipCliente, String userAgent) {
        return new AvisoViagem(destino, dataTerminoViagem, ipCliente, userAgent, cartao);
    }

}
