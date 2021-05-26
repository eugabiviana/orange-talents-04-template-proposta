package br.com.zupacademy.gabrielaviana.proposta.cartoes;

import br.com.zupacademy.gabrielaviana.proposta.bloqueio.BloqueioRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@FeignClient(name="solicitacao-cartao", url="${cartoes.host}")
public interface CartaoClientFeign {

    @GetMapping("/api/cartoes?idProposta")
    CartaoResponse cadastroCartao(@RequestParam(name="idProposta") Long idProposta);

    @PostMapping("/{id}/bloqueios")
    public void bloqueioCartao(@PathVariable String id, @RequestBody @Valid BloqueioRequest request);
}
