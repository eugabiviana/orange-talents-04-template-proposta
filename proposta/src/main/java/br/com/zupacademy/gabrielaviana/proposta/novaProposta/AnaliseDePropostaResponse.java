package br.com.zupacademy.gabrielaviana.proposta.novaProposta;

public class AnaliseDePropostaResponse {

    private String documento;
    private String nome;
    private Long idProposta;

    private ResultadoSolicitacao resultadoSolicitacao;

    //Getters
    public String getDocumento() {
        return documento;
    }

    public String getNome() {
        return nome;
    }

    public Long getIdProposta() {
        return idProposta;
    }

    public ResultadoSolicitacao getResultadoSolicitacao() {
        return resultadoSolicitacao;
    }

    public Status status() {
        return resultadoSolicitacao.getStatus();
    }
}
