package br.com.zupacademy.gabrielaviana.proposta.viagem;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AvisoViagemResponse {

    private String destino;
    private LocalDateTime instanteAvisoViagem;
    private LocalDate dataTerminoViagem;

    public AvisoViagemResponse(AvisoViagem aviso) {

        this.destino = aviso.getDestino();
        this.instanteAvisoViagem = aviso.getInstanteAvisoViagem();
        this.dataTerminoViagem = aviso.getDataTerminoViagem();
    }

    public String getDestino() {
        return destino;
    }

    public LocalDateTime getInstanteAvisoViagem() {
        return instanteAvisoViagem;
    }

    public LocalDate getDataTerminoViagem() {
        return dataTerminoViagem;
    }

}
