package br.com.zupacademy.gabrielaviana.proposta.novaProposta;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
public class Endereco {

    @NotBlank
    private String cep;
    @NotBlank
    private String rua;
    @NotBlank
    private String numero;
    private String complemento;
    @NotBlank
    private String bairro;
    @NotBlank
    private String cidade;
    @NotBlank
    private String estado;

    //Constructors
    /**
     * @deprecated apenas para o uso do hibernate
     */
    @Deprecated
    Endereco(){

    }
    public Endereco(String cep, String rua, String numero, String complemento, String bairro, String cidade, String estado) {
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }
}
