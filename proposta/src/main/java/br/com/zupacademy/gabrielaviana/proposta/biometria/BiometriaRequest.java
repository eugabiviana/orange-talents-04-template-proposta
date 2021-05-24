package br.com.zupacademy.gabrielaviana.proposta.biometria;

import br.com.zupacademy.gabrielaviana.proposta.cartoes.Cartao;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import java.util.Base64;

public class BiometriaRequest {

    @NotNull @Lob
    private byte[] fingerPrint;

    //Getter

    public byte[] getFingerPrint() {
        return fingerPrint;
    }

    //Constructor
    /**
     *
     * @deprecated apenas para uso do framework
     */
    @Deprecated
    private BiometriaRequest(){

    }

    public BiometriaRequest(@NotNull byte[] fingerPrint) {
        this.fingerPrint = fingerPrint;
    }

    public BiometriaModel toModel(Cartao cartao){
        //String biometria = Base64.getEncoder().encodeToString(fingerPrint.getBytes());
        return new BiometriaModel(fingerPrint,cartao);

    }

}
