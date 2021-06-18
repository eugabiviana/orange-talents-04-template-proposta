package br.com.zupacademy.gabrielaviana.proposta.carteira;

import br.com.zupacademy.gabrielaviana.proposta.cartoes.Cartao;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Carteira {
    @Id
    private String id;
    @NotBlank
    private String idAssociacao;
    @NotBlank
    private String email;
    @NotNull

    @Enumerated(EnumType.STRING)
    private CarteiraTipo carteira;
    @ManyToOne

    private Cartao cartao;

    //construtores
    public Carteira(@NotBlank String idAssociacao, @NotBlank String email, @NotNull CarteiraTipo carteira,
                         Cartao cartao) {
        this.idAssociacao = idAssociacao;
        this.email = email;
        this.carteira = carteira;
        this.cartao = cartao;
    }

    @Deprecated
    public Carteira() {

    }

    public String getId() {
        return id;
    }

    public String getIdAssociacao() {
        return idAssociacao;
    }

    public String getEmail() {
        return email;
    }

    public CarteiraTipo getCarteira() {
        return carteira;
    }

    public Cartao getCartao() {
        return cartao;
    }

}
