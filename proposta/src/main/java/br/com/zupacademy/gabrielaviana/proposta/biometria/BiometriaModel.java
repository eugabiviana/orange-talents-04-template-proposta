package br.com.zupacademy.gabrielaviana.proposta.biometria;

import br.com.zupacademy.gabrielaviana.proposta.cartoes.Cartao;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name= "Biometria")
public class BiometriaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull @Lob
    private byte[] fingerPrint;

    @NotNull
    @ManyToOne
    private Cartao cartao;

    @NotNull
    @CreationTimestamp
    private LocalDateTime cadastradaEm = LocalDateTime.now();

    //Constructors

    /**
     *
     * @deprecated apenas para uso do framework
     */
    @Deprecated
    private BiometriaModel(){

    }

    public BiometriaModel(@NotNull byte[] fingerPrint, Cartao cartao) {
        this.fingerPrint = fingerPrint;
        this.cartao = cartao;
    }

    //Getters
    public Long getId() {
        return id;
    }

    public byte[] getFingerPrint() { return fingerPrint; }

    public Cartao getCartao() {
        return cartao;
    }

    public LocalDateTime getCadastradaEm() {
        return cadastradaEm;
    }
}
