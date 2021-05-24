package br.com.zupacademy.gabrielaviana.proposta.biometria;

import br.com.zupacademy.gabrielaviana.proposta.cartoes.Cartao;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.Base64;

public class BiometriaRequest {

    @NotNull
    private String fingerPrint;

    //Getter

    public String getFingerPrint() {
        return fingerPrint;
    }

    //Constructor
    public BiometriaRequest(@NotNull @JsonProperty("fingerPrint") String fingerPrint) {
        this.fingerPrint = fingerPrint;
    }

    public BiometriaModel toModel(Cartao cartao){
        String biometria = Base64.getEncoder().encodeToString(fingerPrint.getBytes());
        return new BiometriaModel(biometria,cartao);

    }

}
