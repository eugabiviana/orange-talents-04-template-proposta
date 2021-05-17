package br.com.zupacademy.gabrielaviana.proposta.cartoes;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="solicitacao-cartao", url= "http://localhost:8888")
public interface CartaoClientFeign {

    @GetMapping("/api/cartoes?idProposta")
    CartaoResponse cadastroCartao(@RequestParam(name="idProposta") Long idProposta);
}
