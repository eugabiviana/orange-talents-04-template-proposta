package br.com.zupacademy.gabrielaviana.proposta.bloqueio;

import javax.validation.constraints.NotBlank;

public class BloqueioRequest {

    @NotBlank
    private String ipBloqueio;
    @NotBlank
    private String userAgent;

    //Getters
    public String getIpBloqueio() {
        return ipBloqueio;
    }

    public String getUserAgent() {
        return userAgent;
    }

    //Constructor
    public BloqueioRequest(String ipBloqueio, String userAgent) {
        this.ipBloqueio = ipBloqueio;
        this.userAgent = userAgent;
    }
}
