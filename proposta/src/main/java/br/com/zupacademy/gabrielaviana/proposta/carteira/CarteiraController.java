package br.com.zupacademy.gabrielaviana.proposta.carteira;

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
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/carteiras")
public class CarteiraController {

    @Autowired
    private CartaoRepository cartaoRepository;
    @Autowired
    private CarteiraRepository carteiraRepository;

    @Autowired
    private CartaoClientFeign cartaoClienteFeing;
    @Autowired
    private ExecutorTransacao executorTransacao;


    private final Logger logger = LoggerFactory.getLogger(CarteiraController.class);


    @PostMapping("/{idCartao}")
    public ResponseEntity<?> associarCarteira(@PathVariable("idCartao") String id,
                                              @RequestBody @Valid CarteiraRequest request,
                                              UriComponentsBuilder uriBuilder){
        Optional<Cartao> cartao = cartaoRepository.findById(id);
        if(cartao.isEmpty()){
            logger.warn("Cartão {} inexistente=", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cartão inexistente=");
        }

        if(carteiraRepository.existsByCartaoAndCarteira(cartao.get(), request.getCarteira())) {
            logger.warn("Cartão já associado");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cartão foi associado à uma cateira");
        }
        Carteira carteiraCriada = associarCartao(cartao.get(), request);
        URI uri = uriBuilder.path("/carteiras/{id}").build(carteiraCriada.getId());
        return ResponseEntity.created(uri).build();
    }

    public Carteira associarCartao(Cartao cartao, CarteiraRequest request) {
        try {
            CarteiraResponse carteiraResponse = cartaoClienteFeing.associarCarteira(cartao.getId(), request);
            Carteira novaCarteira = carteiraResponse.toModel(request, cartao);
            executorTransacao.salvaEComita(novaCarteira);
            return novaCarteira;
        } catch (FeignException.UnprocessableEntity e) {
            logger.error(" Erro = {}", e.toString());
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,"Falha ao tentar associar o cartão");
        }
    }

}
