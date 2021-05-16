package br.com.zupacademy.gabrielaviana.proposta.novaProposta;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="analise-solicitacao", url= "http://localhost:9999")
public interface AnaliseSolicitacaoClient {

    @PostMapping("/api/solicitacao")
    AnaliseDePropostaResponse consulta(AnaliseDePropostaRequest request);
}
