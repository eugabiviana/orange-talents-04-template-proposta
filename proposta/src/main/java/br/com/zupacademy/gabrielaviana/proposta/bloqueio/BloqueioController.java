package br.com.zupacademy.gabrielaviana.proposta.bloqueio;

import br.com.zupacademy.gabrielaviana.proposta.cartoes.Cartao;
import br.com.zupacademy.gabrielaviana.proposta.cartoes.CartaoClientFeign;
import br.com.zupacademy.gabrielaviana.proposta.cartoes.CartaoRepository;
import br.com.zupacademy.gabrielaviana.proposta.compartilhado.ExecutorTransacao;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/bloqueios")
public class BloqueioController {

    @Autowired
    private CartaoRepository cartaoRepository;
    @Autowired
    private ExecutorTransacao executorTransacao;
    @Autowired
    private CartaoClientFeign cartaoClienteFeing;

    private final Logger logger = LoggerFactory.getLogger(BloqueioController.class);

    @PostMapping("/{idCartao}")
    public ResponseEntity<?> bloquearCartao(@PathVariable("idCartao") String id,
                                            HttpServletRequest servletRequest,
                                            @RequestBody @Valid BloqueioRequest request){

        Optional<Cartao> cartao = cartaoRepository.findById(id);
        if(cartao.isEmpty()){
            logger.warn("Cartão {} inexistente=", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cartão inexistente!");
        }
        if(cartao.get().verificaBloqueado()) {
            logger.warn("O cartão {} já está bloqueado=", id);
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Cartão já bloqueado!");
        }

        BloqueioModel bloqueio = new BloqueioModel(servletRequest.getLocalAddr(),
                servletRequest.getHeader("User-Agent"), cartao.get());
        bloquearCartao(bloqueio, cartao.get(), request);
        logger.info("Cartão bloqueado com sucesso");
        return ResponseEntity.ok().build();
    }

    /* -- Funcionalidade do card 060
    Notificando o sistema legado do bloqueio do nosso cartão--
    Quando o retorno do sistema bancário retornar sucesso (status code na faixa 200) = "BLOQUEADO".
    Quando o retorno do sistema bancário retornar erro (status code na faixa 400 ou 500) = não  alterar o estado do cartão.
    */
    private void bloquearCartao(BloqueioModel bloqueio, Cartao cartao, BloqueioRequest request) {
        try {
            cartaoClienteFeing.bloqueioCartao(cartao.getId(), request);
            cartao.setBloqueio(bloqueio);
            executorTransacao.atualizaEComita(cartao);
        } catch (FeignException e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,"O bloqueio do cartão falhou!");
        }

    }

}

