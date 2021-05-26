package br.com.zupacademy.gabrielaviana.proposta.bloqueio;

import br.com.zupacademy.gabrielaviana.proposta.cartoes.Cartao;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class BloqueioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @CreationTimestamp
    private LocalDateTime dataBloqueio = LocalDateTime.now();
    @NotBlank
    private String ipBloqueio;
    @NotBlank
    private String userAgent;
    @OneToOne @NotNull
    private Cartao cartaoBloqueado;

    //Constructors
    /**
     * @deprecated para uso do framework
     */
    @Deprecated
    public BloqueioModel(){

    }
    public BloqueioModel(Long id, LocalDateTime dataBloqueio, String ipBloqueio, String userAgent, Cartao cartaoBloqueado) {
        this.id = id;
        this.dataBloqueio = dataBloqueio;
        this.ipBloqueio = ipBloqueio;
        this.userAgent = userAgent;
        this.cartaoBloqueado = cartaoBloqueado;
    }

    public BloqueioModel(@NotBlank String ipCliente,
                         @NotBlank String userAgent, Cartao cartao) {

        this.ipBloqueio = ipBloqueio;
        this.userAgent = userAgent;
        this.cartaoBloqueado = cartao;
    }
}
