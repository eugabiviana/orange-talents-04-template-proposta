package br.com.zupacademy.gabrielaviana.proposta.novaProposta;

public enum ResultadoSolicitacao {

    COM_RETRICAO(Status.NAO_ELEGIVEL),
    SEM_RESTRICAO(Status.ELEGIVEL);

    //Constructor
    private Status status;
    ResultadoSolicitacao(Status status) {
        this.status = status;
    }

    //Getter
    public Status getStatus() {
        return status;
    }
}
